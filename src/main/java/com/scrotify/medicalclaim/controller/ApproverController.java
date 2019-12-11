package com.scrotify.medicalclaim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scrotify.medicalclaim.dto.ApproverClaimResponseDto;
import com.scrotify.medicalclaim.dto.ApproverDto;
import com.scrotify.medicalclaim.dto.ApproverResponseDto;
import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.exception.ApproverNotFound;
import com.scrotify.medicalclaim.service.ApproverService;
import com.scrotify.medicalclaim.service.ClaimService;

@RestController
@RequestMapping("/approvers")
@CrossOrigin
public class ApproverController {
	
	@Autowired
	ApproverService approverService;

	@Autowired
	ClaimService claimService;
	
	@PostMapping("")
	public ResponseEntity<ApproverResponseDto> loginApprover(@RequestBody ApproverDto approverDto) throws ApproverNotFound {
		return new ResponseEntity<ApproverResponseDto>(approverService.loginApprover(approverDto), HttpStatus.OK);
	}
	
	@GetMapping("/{approverId}")
	public ResponseEntity<List<ClaimRequestResponseDto>> getByApproverId(@PathVariable Long approverId) throws ApproverNotFound {
		return new ResponseEntity<>(approverService.getByApproverId(approverId), HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{approvers/{approverId}/claims/{claimRequestId}")
	public ApproverClaimResponseDto verifyClaimRequest(@RequestBody @RequestParam Long approverId,@RequestParam String role, @RequestParam Long claimRequestID) {
		ApproverClaimResponseDto approverClaimResponseDto=claimService.verifyClaimRequest(approverId, role, claimRequestID);
		return approverClaimResponseDto;
	}
}
