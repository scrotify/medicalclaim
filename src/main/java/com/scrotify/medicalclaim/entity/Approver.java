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
@Table(name="approver")
public class Approver {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long approverId;
	private String approverName;
	private String approverEmail;
	private String approverPassword;
	private String approverRole;
}