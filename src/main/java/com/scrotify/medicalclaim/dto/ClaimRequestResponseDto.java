package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClaimRequestResponseDto {
	
	private Long claimId;
	private String claimStatus;
	private String reason;

}
