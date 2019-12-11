package com.scrotify.medicalclaim.service;

import java.util.List;
 import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.medicalclaim.dto.ApiResponse;
 import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.ClaimRequest;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.exception.ClaimIdNotFoundException;
 import com.scrotify.medicalclaim.dto.ApproverClaimResponseDto;
import com.scrotify.medicalclaim.entity.Approver;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.ClaimRequest;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.exception.PolicyNotFoundException;
import com.scrotify.medicalclaim.repository.ApproverRepository;
 
import com.scrotify.medicalclaim.repository.ClaimRepository;
import com.scrotify.medicalclaim.repository.ClaimRequestRepository;
import com.scrotify.medicalclaim.repository.PolicyDetailRepository;
import com.scrotify.medicalclaim.util.MedicalClaimConstants;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private PolicyDetailRepository policyDetailRepository;

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private ClaimRequestRepository claimRequestRepository;

	@Autowired
	private ApproverRepository approverRepository;

	@Override
	public Claim getClaimById(Long claimId) {
		Optional<Claim> claimEntity = claimRepository.findByClaimId(claimId);
		if(claimEntity.isPresent()) {
			return claimEntity.get();
		}
		return null; 
	}


	@Override
	public List<Claim> getAllClaims() {
		List<Claim> claimEntity = claimRepository.findAll();
		if(!claimEntity.isEmpty()) {
			return claimEntity;
		}
		return null; 
	}



	@Override
	public ApiResponse postClaims(Claim claim) {
		ApiResponse response = new ApiResponse();
		Optional<PolicyDetail> policyDetailOptional = policyDetailRepository.findById(claim.getPolicyId());
		if (policyDetailOptional.isPresent()) {
			claim.setPolicyDetail(policyDetailOptional.get());
			double totalClaim = claim.getMedicineFee() + claim.getDoctorFee() + claim.getNursingFee()
					+ claim.getOthersFee();
			totalClaim += claim.getRoomFee() + claim.getSurgeryFee() + claim.getXrayFee();
			claim.setStatus(MedicalClaimConstants.CLAIM_PENDING_REGISTER_MSG);
			claim.setTotalClaimAmount(totalClaim);
 			claim = claimRepository.save(claim);
			response.setStatusCode(MedicalClaimConstants.CLAIM_SUCCESS_REGISTER_STATUS_CODE);
			response.setMessage(MedicalClaimConstants.CLAIM_SUCCESS_REGISTER_MSG + claim.getClaimId());
		} else {
			response.setStatusCode(MedicalClaimConstants.CLAIM_REGISTER_FAILED_STATUS_CODE);
			response.setMessage(MedicalClaimConstants.CLAIM_REGISTER_FAILED_MSG);
		}
		return response;
	}


	@Override
	public List<PolicyDetail> getAllPolicy() {
		return policyDetailRepository.findAll();
	}

	@Override
	public PolicyDetail getPolicyById(Long policyId) throws PolicyNotFoundException {
		if (policyDetailRepository.findById(policyId).isPresent()) {
			return policyDetailRepository.findById(policyId).get();
		} else {
			throw new PolicyNotFoundException(MedicalClaimConstants.POLICY_NOT_FOUND);
		}
	}

	/**
	 *
	 */
	@Override
	public ApproverClaimResponseDto verifyClaimRequest(Long approverId, String role, Long claimRequestID) {
		ApproverClaimResponseDto approverClaimResponseDto = new ApproverClaimResponseDto();;
		Optional<Approver> appro = approverRepository.findByApproverId(approverId);
		if (appro.isPresent()) {
			Optional<ClaimRequest> claimRequest = claimRequestRepository.findByClaimRequestId(claimRequestID);
			if (claimRequest.isPresent()) {
				if (appro.get().getApproverRole().equalsIgnoreCase(role)) {
					Optional<Claim> claim = claimRepository.findByClaimId(claimRequest.get().getClaimId());
					if (claim.isPresent()) {
						Optional<PolicyDetail> plociyId = policyDetailRepository
								.findByPolicyId(claim.get().getPolicyId());
						if (plociyId.isPresent()) {
							if (claim.get().getTotalClaimAmount() > plociyId.get().getPolicyLimit()) {
								ClaimRequest statusUpdate = new ClaimRequest();
								statusUpdate.setClaimStatus("approved");
							} else {
								ClaimRequest level2 = new ClaimRequest();
								level2.setClaimStatus("rejected");
								level2.setReason("above policy limit");
								level2.setApproverRole("level2");
								claimRequestRepository.save(level2);
							}
						} else {
							
							approverClaimResponseDto.setMessage("policy id not present");
							approverClaimResponseDto.setStatusCode(404);
						}
					}else {
						approverClaimResponseDto.setMessage("claim id not present");
						approverClaimResponseDto.setStatusCode(404);
					}
				} else {
					approverClaimResponseDto.setMessage("you don't have present claim request ");
					approverClaimResponseDto.setStatusCode(404);
				}
			} else {
				approverClaimResponseDto.setMessage("claim request id is not present");
				approverClaimResponseDto.setStatusCode(404);
			}
		} else {
			approverClaimResponseDto.setMessage("Approver not present");
			approverClaimResponseDto.setStatusCode(404);
		}
		return approverClaimResponseDto;
	}
  
	@Override
	public ClaimRequestResponseDto validateUser(Long claimId) throws ClaimIdNotFoundException {
		ClaimRequestResponseDto claimRequestResponseDto = new ClaimRequestResponseDto();
		Optional<Claim> claim = claimRepository.findByClaimId(claimId);
		Optional<PolicyDetail> policyDetail = policyDetailRepository.findByClaimsClaimId(claim.get().getClaimId());
		if (policyDetail.isPresent()) {
			if (!policyDetail.get().getAilments().isEmpty()) {
				if (policyDetail.get().getAilments().get(0).getAilment().equals(claim.get().getAliment())) {
					if (!policyDetail.get().getHospitals().isEmpty()) {
						if (policyDetail.get().getHospitals().get(0).getHospitalName()
								.equals(claim.get().getHospitalDetails())) {
							if (policyDetail.get().getPolicyId().equals(claim.get().getPolicyDetail().getPolicyId())) {
								ClaimRequest requestclaim = new ClaimRequest();
								requestclaim.setClaimId(claim.get().getClaimId());
								requestclaim.setClaimStatus(MedicalClaimConstants.CLAIM_STATUS);
								requestclaim.setReason(MedicalClaimConstants.CLAIM_REASON);
								requestclaim.setApproverRole(MedicalClaimConstants.CLAIM_APPROVER_ROLE);
								claimRequestRepository.save(requestclaim);
								claimRequestResponseDto.setMessage(MedicalClaimConstants.CLAIM_SUCCESS_VALIDATE_MESSAGE);
								claimRequestResponseDto.setStatusCode(200);
							} else {
								claimRequestResponseDto.setMessage(MedicalClaimConstants.CLAIM_VALIDATE_POLICY_ID_FAILURE_MESSAGE);
								claimRequestResponseDto.setStatusCode(404);
							}

						} else {

							claimRequestResponseDto.setMessage(MedicalClaimConstants.CLAIM_VALIDATE_HOSPITAL_NOT_MATCHED_FAILURE_MESSAGE);
							claimRequestResponseDto.setStatusCode(404);
						}
					}else {
						claimRequestResponseDto.setMessage(MedicalClaimConstants.CLAIM_VALIDATE_HOSPITAL_EMPTY_FAILURE_MESSAGE);
						claimRequestResponseDto.setStatusCode(404);
					}
				}else {
					claimRequestResponseDto.setMessage(MedicalClaimConstants.CLAIM_VALIDATE_AILMENT_NOT_MATCHED_FAILURE_MESSAGE);
					claimRequestResponseDto.setStatusCode(404);
					}
					}else {
						claimRequestResponseDto.setMessage(MedicalClaimConstants.CLAIM_VALIDATE_AILMENT_EMPTY_FAILURE_MESSAGE);
						claimRequestResponseDto.setStatusCode(404);
					}
				} else {
					throw new ClaimIdNotFoundException(MedicalClaimConstants.CLAIM_VALIDATE_CLAIM_ID_FAILURE_MESSAGE);
  				}
				return claimRequestResponseDto;
			}
		
	
		}
		
