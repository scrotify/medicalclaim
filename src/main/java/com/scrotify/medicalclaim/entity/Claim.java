package com.scrotify.medicalclaim.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the claim database table.
 */
@Entity
@Table(name = "claim")
//@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLAIM_CLAIMID_GENERATOR", sequenceName = "SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_CLAIMID_GENERATOR")
	@Column(name = "claim_id", unique = true, nullable = false)
	private Long claimId;

	@Column(name = "admission_date")
	private LocalDate admissionDate;

	@Column(name = "aliment")
	private String aliment;

	@Column(name = "name")
	private String name;

	@Column(name = "diagnosis")
	private String diagnosis;

	@Column(name = "discharge_date")
	private LocalDate dischargeDate;

	@Column(name = "discharge_summary")
	private String dischargeSummary;

	@Column(name = "doctor_fee", nullable = true)
	private Double doctorFee;

	@Column(name = "hospital_details")
	private String hospitalDetails;

	@Column(name = "medicine_fee", nullable = true)
	private Double medicineFee;

	@Column(name = "more_details")
	private String moreDetails;

	@Column(name = "more_details_status", columnDefinition = "Boolean default false")
	private Boolean moreDetailsStatus;

	@Column(name = "nursing_fee", nullable = true)
	private Double nursingFee;

	@Column(name = "others_fee", nullable = true)
	private Double othersFee;

	@Column(name = "room_fee", nullable = true)
	private Double roomFee;

	@Column(name = "status")
	private String status;

	@Column(name = "surgery_fee", nullable = true)
	private Double surgeryFee;

	@Column(name = "total_claim_amount")
	private Double totalClaimAmount;

	@Column(name = "xray_fee", nullable = true)
	private Double xrayFee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id")
	private PolicyDetail policyDetail;

	@Transient
	private Long policyId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isMoreDetailsStatus() {
		return moreDetailsStatus;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public Claim() {
	}

	public Long getClaimId() {
		return this.claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public LocalDate getAdmissionDate() {
		return this.admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getAliment() {
		return this.aliment;
	}

	public void setAliment(String aliment) {
		this.aliment = aliment;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public LocalDate getDischargeDate() {
		return this.dischargeDate;
	}

	public void setDischargeDate(LocalDate dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDischargeSummary() {
		return this.dischargeSummary;
	}

	public void setDischargeSummary(String dischargeSummary) {
		this.dischargeSummary = dischargeSummary;
	}

	public Double getDoctorFee() {
		return this.doctorFee;
	}

	public void setDoctorFee(Double doctorFee) {
		this.doctorFee = doctorFee;
	}

	public String getHospitalDetails() {
		return this.hospitalDetails;
	}

	public void setHospitalDetails(String hospitalDetails) {
		this.hospitalDetails = hospitalDetails;
	}

	public Double getMedicineFee() {
		return this.medicineFee;
	}

	public void setMedicineFee(Double medicineFee) {
		this.medicineFee = medicineFee;
	}

	public String getMoreDetails() {
		return this.moreDetails;
	}

	public void setMoreDetails(String moreDetails) {
		this.moreDetails = moreDetails;
	}

	public Boolean getMoreDetailsStatus() {
		return this.moreDetailsStatus;
	}

	public void setMoreDetailsStatus(Boolean moreDetailsStatus) {
		this.moreDetailsStatus = moreDetailsStatus;
	}

	public Double getNursingFee() {
		return this.nursingFee;
	}

	public void setNursingFee(Double nursingFee) {
		this.nursingFee = nursingFee;
	}

	public Double getOthersFee() {
		return this.othersFee;
	}

	public void setOthersFee(Double othersFee) {
		this.othersFee = othersFee;
	}

	public Double getRoomFee() {
		return this.roomFee;
	}

	public void setRoomFee(Double roomFee) {
		this.roomFee = roomFee;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getSurgeryFee() {
		return this.surgeryFee;
	}

	public void setSurgeryFee(Double surgeryFee) {
		this.surgeryFee = surgeryFee;
	}

	public Double getTotalClaimAmount() {
		return this.totalClaimAmount;
	}

	public void setTotalClaimAmount(Double totalClaimAmount) {
		this.totalClaimAmount = totalClaimAmount;
	}

	public Double getXrayFee() {
		return this.xrayFee;
	}

	public void setXrayFee(Double xrayFee) {
		this.xrayFee = xrayFee;
	}

	public PolicyDetail getPolicyDetail() {
		return this.policyDetail;
	}

	public void setPolicyDetail(PolicyDetail policyDetail) {
		this.policyDetail = policyDetail;
	}

}
