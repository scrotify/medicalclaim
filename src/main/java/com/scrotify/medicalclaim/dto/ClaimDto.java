package com.scrotify.medicalclaim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
public class ClaimDto {

    private LocalDate admissionDate;

    private String aliment;

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

    public double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public String getHospitalDetails() {
        return hospitalDetails;
    }

    public void setHospitalDetails(String hospitalDetails) {
        this.hospitalDetails = hospitalDetails;
    }

    public double getMedicineFee() {
        return medicineFee;
    }

    public void setMedicineFee(double medicineFee) {
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

    public double getNursingFee() {
        return nursingFee;
    }

    public void setNursingFee(double nursingFee) {
        this.nursingFee = nursingFee;
    }

    public double getOthersFee() {
        return othersFee;
    }

    public void setOthersFee(double othersFee) {
        this.othersFee = othersFee;
    }

    public double getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(double roomFee) {
        this.roomFee = roomFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSurgeryFee() {
        return surgeryFee;
    }

    public void setSurgeryFee(double surgeryFee) {
        this.surgeryFee = surgeryFee;
    }

    public double getXrayFee() {
        return xrayFee;
    }

    public void setXrayFee(double xrayFee) {
        this.xrayFee = xrayFee;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    private String diagnosis;

    private LocalDate dischargeDate;

    private String dischargeSummary;

    private double doctorFee;

    private String hospitalDetails;

    private double medicineFee;

    private String moreDetails;

    private byte moreDetailsStatus;

    private double nursingFee;

    private double othersFee;

    private double roomFee;

    private String status;

    private double surgeryFee;

    private double xrayFee;

    private Long policyId;

}
