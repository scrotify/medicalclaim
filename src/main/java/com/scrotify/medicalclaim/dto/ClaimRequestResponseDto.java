package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaimRequestResponseDto {
	

	private Long claimRequestId;
 	private String message;
	private Integer statusCode;
	private Long claimId;
	private String claimStatus;
	private Long policyId;
	private String policyHolderName;
	private String hospitalName;
	private String diagnosis;
	private Double totalClaimAmount;

}
