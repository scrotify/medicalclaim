package com.scrotify.medicalclaim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.medicalclaim.dto.ApiResponse;
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
		return claimRepository.getOne(claimId);
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

	@Override
	public ApproverClaimResponseDto verifyClaimRequest(Long approverId, Long claimRequestID) {
		ApproverClaimResponseDto approverClaimResponseDto = null;
		Optional<Approver> appro = approverRepository.findByApproverId(approverId);
		if (appro.isPresent()) {
			Optional<ClaimRequest> claimRequest = claimRequestRepository.findByClaimRequestId(claimRequestID);
			if (claimRequest.isPresent()) {
				Optional<Claim> claim = claimRepository.findByClaimId(claimRequest.get().getClaimId());
				if (claim.isPresent()) {

				}else {
					
				}
			}else {
				
			}
		}else {
			
		}
		return approverClaimResponseDto;
	}

}
