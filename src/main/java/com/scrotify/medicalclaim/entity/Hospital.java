package com.scrotify.medicalclaim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="hospital")
public class Hospital {
	
	@Id
	@GeneratedValue
	@Column(name = "hospital_id")
	private Long hospitalId;
	
	@Column
	private String hospitalName;
	
	@Column
	private String hospitalLocation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
    private PolicyDetail policyDetail;


}
