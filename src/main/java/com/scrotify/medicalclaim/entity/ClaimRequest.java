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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "claimrequest")
public class ClaimRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimRequestId;
	private Long claimId;
	private String claimStatus;
        private String approverRole;
        private String reason;
}
