package com.scrotify.medicalclaim.service;

import com.scrotify.medicalclaim.dto.ClaimRequestResponseDto;
import com.scrotify.medicalclaim.exception.ClaimIdNotFoundException;

public interface ClaimService {
//	 public ApiResponse postClaims(Claim claim);
	 
	public ClaimRequestResponseDto validateUser(Long claimId) throws ClaimIdNotFoundException;
}
