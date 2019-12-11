package com.scrotify.medicalclaim.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.ClaimRequest;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.exception.ClaimIdNotFoundException;
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

	public ApiResponse postClaims(Claim claim) {
		ApiResponse response = new ApiResponse();
		Optional<PolicyDetail> policyDetailOptional = policyDetailRepository
				.findById(claim.getPolicyDetail().getPolicyId());
		if (policyDetailOptional.isPresent()) {
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
	public ClaimRequestResponseDto validateUser(Long claimId) throws ClaimIdNotFoundException {
		ClaimRequestResponseDto claimRequestResponseDto = new ClaimRequestResponseDto();
		Optional<Claim> claim = claimRepository.findByClaimId(claimId);
		Optional<PolicyDetail> policyDetail = policyDetailRepository.findByPolicyId(claim.get().getClaimId());
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

				}return claimRequestResponseDto;
			}
		
	
		}
		
