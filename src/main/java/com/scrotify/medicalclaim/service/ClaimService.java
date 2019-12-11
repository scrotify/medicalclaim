package com.scrotify.medicalclaim.service;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.entity.Claim;

public interface ClaimService {
	 public ApiResponse postClaims(Claim claim);
}
