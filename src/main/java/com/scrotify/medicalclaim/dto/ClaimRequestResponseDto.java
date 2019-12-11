package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClaimRequestResponseDto {
	
	private Long claimRequestId;
	private Long claimId;
	private String claimStatus;
	private Long policyId;
	private String policyHolderName;
	private String hospitalName;
	private String diagnosis;
	private Double totalClaimAmount;

}
