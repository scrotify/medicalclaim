package com.scrotify.medicalclaim.service;

import java.util.List;
import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.exception.ClaimIdNotFoundException;
import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ApproverClaimResponseDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.exception.PolicyNotFoundException;


public interface ClaimService {

    public ApiResponse postClaims(Claim claim);
    public ClaimRequestResponseDto validateUser(Long claimId) throws ClaimIdNotFoundException;
    public List<PolicyDetail> getAllPolicy();
    public PolicyDetail getPolicyById(Long policyId) throws PolicyNotFoundException;
    public Claim getClaimById(Long claimId);
    public ApproverClaimResponseDto verifyClaimRequest(Long approverId,String role, Long claimRequestID);
    public List<Claim> getAllClaims();

}
