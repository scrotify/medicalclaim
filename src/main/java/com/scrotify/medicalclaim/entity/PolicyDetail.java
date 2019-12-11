package com.scrotify.medicalclaim.entity;

import javax.persistence.*;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the policy_details database table.
 */

@Entity
@Table(name = "policy_details")
//@NamedQuery(name = "PolicyDetail.findAll", query = "SELECT p FROM PolicyDetail p")
public class PolicyDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "POLICY_DETAILS_POLICYID_GENERATOR", sequenceName = "SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_DETAILS_POLICYID_GENERATOR")
    @Column(name = "policy_id", unique = true, nullable = false)
    private Long policyId;

    @Column(name = "policy_limit")
    private double policyLimit;

    @Column(name = "policy_name")
    private String policyName;
    
    @OneToMany(mappedBy="policyDetail")
    private List<Hospital> hospitals;
    
    @OneToMany(mappedBy="policyDetail")
    private List<Ailment> ailments;
    

    @OneToMany(mappedBy = "policyDetail")
    private List<Claim> claims;

    public PolicyDetail() {
    }

    public Long getPolicyId() {
        return this.policyId;
    }

    public void setPolicyId(Long policyId) {
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
    

    public List<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public List<Ailment> getAilments() {
		return ailments;
	}

	public void setAilments(List<Ailment> ailments) {
		this.ailments = ailments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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