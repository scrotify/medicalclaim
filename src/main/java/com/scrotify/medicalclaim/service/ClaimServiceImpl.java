package com.scrotify.medicalclaim.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ApproverClaimResponseDto;
import com.scrotify.medicalclaim.entity.Approver;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.ClaimRequest;
import com.scrotify.medicalclaim.entity.PolicyDetail;
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

    public ApiResponse postClaims(Claim claim) {
        ApiResponse response = new ApiResponse();
        Optional<PolicyDetail> policyDetailOptional = policyDetailRepository.findById(claim.getPolicyDetail().getPolicyId());
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
	public ApproverClaimResponseDto verifyClaimRequest(Long approverId, Long claimRequestID) {
		ApproverClaimResponseDto approverClaimResponseDto=null;
	Optional<Approver> appro=approverRepository.findByApproverId(approverId);
	if(appro.isPresent()) {
		Optional<ClaimRequest> claim=claimRequestRepository.findByClaimRequestId(claimRequestID);
		if(claim.isPresent()) {
			
		}
	}
		return approverClaimResponseDto;
	}

}
