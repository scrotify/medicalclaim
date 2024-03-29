package com.scrotify.medicalclaim.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "policy_holder")
public class PolicyHolder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyHolderId;
	private String name;
	private Long policyId;
	private String mobile;


}
