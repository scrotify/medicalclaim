package com.scrotify.medicalclaim.dto;

import java.time.LocalDate;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClaimDto {

    private String name;
    
    private Double totalClaimAmount;

    private LocalDate admissionDate;

    private String aliment;

    private String diagnosis;

    private LocalDate dischargeDate;

    private String dischargeSummary;

    private Double doctorFee;

    private String hospitalDetails;

    private Double medicineFee;

    private String moreDetails;

    private byte moreDetailsStatus;

    private Double nursingFee;

    private Double othersFee;

    private Double roomFee;

    private String status;

    private Double surgeryFee;

    private Double xrayFee;

    private Long policyId;

    
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAliment() {
        return aliment;
    }

    public void setAliment(String aliment) {
        this.aliment = aliment;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDischargeSummary() {
        return dischargeSummary;
    }

    public void setDischargeSummary(String dischargeSummary) {
        this.dischargeSummary = dischargeSummary;
    }

    public Double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(Double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public String getHospitalDetails() {
        return hospitalDetails;
    }

    public void setHospitalDetails(String hospitalDetails) {
        this.hospitalDetails = hospitalDetails;
    }

    public Double getMedicineFee() {
        return medicineFee;
    }

    public void setMedicineFee(Double medicineFee) {
        this.medicineFee = medicineFee;
    }

    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public byte getMoreDetailsStatus() {
        return moreDetailsStatus;
    }

    public void setMoreDetailsStatus(byte moreDetailsStatus) {
        this.moreDetailsStatus = moreDetailsStatus;
    }

    public Double getNursingFee() {
        return nursingFee;
    }

    public void setNursingFee(Double nursingFee) {
        this.nursingFee = nursingFee;
    }

    public Double getOthersFee() {
        return othersFee;
    }

    public void setOthersFee(Double othersFee) {
        this.othersFee = othersFee;
    }

    public Double getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(Double roomFee) {
        this.roomFee = roomFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSurgeryFee() {
        return surgeryFee;
    }

    public void setSurgeryFee(Double surgeryFee) {
        this.surgeryFee = surgeryFee;
    }

    public Double getXrayFee() {
        return xrayFee;
    }

    public void setXrayFee(Double xrayFee) {
        this.xrayFee = xrayFee;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the totalClaimAmount
	 */
	public Double getTotalClaimAmount() {
		return totalClaimAmount;
	}

	/**
	 * @param totalClaimAmount the totalClaimAmount to set
	 */
	public void setTotalClaimAmount(Double totalClaimAmount) {
		this.totalClaimAmount = totalClaimAmount;
	}

}
