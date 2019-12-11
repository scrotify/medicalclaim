package com.scrotify.medicalclaim.service;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.dto.ApproverClaimResponseDto;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.exception.PolicyNotFoundException;

import java.util.List;

public interface ClaimService {

    public ApiResponse postClaims(Claim claim);
    public List<PolicyDetail> getAllPolicy();
    public PolicyDetail getPolicyById(Long policyId) throws PolicyNotFoundException;
    public Claim getClaimById(Long claimId);
	public ApproverClaimResponseDto verifyClaimRequest(Long approverId, Long claimRequestID);
}
