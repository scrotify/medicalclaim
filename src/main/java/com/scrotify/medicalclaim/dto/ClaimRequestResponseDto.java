package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ClaimRequestResponseDto {
	
	private String message;
	private Integer statusCode;
	private Long claimId;
	private String claimStatus;
	private String reason;

}
