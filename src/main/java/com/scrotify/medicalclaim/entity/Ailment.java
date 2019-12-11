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
@Table(name="ailment")
public class Ailment {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ailment_id")
	private Integer ailmentId;
	
	@Column
	private String ailment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
    private PolicyDetail policyDetail;
	
}
