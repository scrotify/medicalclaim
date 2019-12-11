package com.scrotify.medicalclaim.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the policy_details database table.
 * 
 */
@Entity
@Table(name="policy_details")
@NamedQuery(name="PolicyDetail.findAll", query="SELECT p FROM PolicyDetail p")
public class PolicyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POLICY_DETAILS_POLICYID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLICY_DETAILS_POLICYID_GENERATOR")
	@Column(name="policy_id", unique=true, nullable=false)
	private String policyId;

	@Column(name="policy_limit")
	private double policyLimit;

	@Column(name="policy_name")
	private String policyName;

	@OneToMany(mappedBy="policyDetail")
	private List<Claim> claims;

	public PolicyDetail() {
	}

	public String getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public double getPolicyLimit() {
		return this.policyLimit;
	}

	public void setPolicyLimit(double policyLimit) {
		this.policyLimit = policyLimit;
	}

	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setPolicyDetail(this);
		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setPolicyDetail(null);
		return claim;
	}

}