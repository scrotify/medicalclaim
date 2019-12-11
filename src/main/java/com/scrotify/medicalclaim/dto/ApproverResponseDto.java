package com.scrotify.medicalclaim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApproverResponseDto {

	private Long approverId;
	private String approverName;
	private String message;
	private Integer statusCode;
	private String approverRole;

}
