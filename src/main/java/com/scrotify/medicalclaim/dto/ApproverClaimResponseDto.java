package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ApproverClaimResponseDto {
	
private String claimStatus;
private String reason;
private String message;
private String approverRole;
private Integer statusCode;
}
