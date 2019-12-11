package com.scrotify.medicalclaim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scrotify.medicalclaim.dto.ApproverClaimResponseDto;
import com.scrotify.medicalclaim.service.ClaimService;

@RestController
public class ApproverController {
	
	@Autowired
	ClaimService claimService;
	
	@PutMapping("/{approvers/{approverId}/claims/{claimRequestId}")
	public ApproverClaimResponseDto verifyClaimRequest(@RequestBody @RequestParam Long approverId,@RequestParam String role, @RequestParam Long claimRequestID) {
		ApproverClaimResponseDto approverClaimResponseDto=claimService.verifyClaimRequest(approverId, role, claimRequestID);
		return approverClaimResponseDto;
	}
}
