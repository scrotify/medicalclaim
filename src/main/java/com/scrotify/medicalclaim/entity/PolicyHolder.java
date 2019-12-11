package com.scrotify.medicalclaim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHolder {
	
	private Long policyHolderId;
	private String name;
	private Long policyId;
	private String mobile;


}
