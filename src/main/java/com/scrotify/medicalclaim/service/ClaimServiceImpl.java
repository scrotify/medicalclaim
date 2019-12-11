package com.scrotify.medicalclaim.service;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.repository.ClaimRepository;
import com.scrotify.medicalclaim.repository.PolicyDetailRepository;
import com.scrotify.medicalclaim.util.MedicalClaimConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {


    @Autowired
    private PolicyDetailRepository policyDetailRepository;

    @Autowired
    private ClaimRepository claimRepository;

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

}
