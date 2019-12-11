package com.scrotify.medicalclaim.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

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
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$(?:\\\\.[a-zA-Z0-9-]+)*$")
	private String approverEmail;
	private String approver_password;
	private String approverRole;
}
