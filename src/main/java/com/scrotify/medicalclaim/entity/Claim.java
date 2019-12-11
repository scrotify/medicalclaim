package com.scrotify.medicalclaim.entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


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

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    @Column(name = "discharge_summary")
    private String dischargeSummary;

    @Column(name = "doctor_fee")
    private double doctorFee;

    @Column(name = "hospital_details")
    private String hospitalDetails;

    @Column(name = "medicine_fee")
    private double medicineFee;

    @Column(name = "more_details")
    private String moreDetails;

    @Column(name = "more_details_status")
    private boolean moreDetailsStatus;

    @Column(name = "nursing_fee")
    private double nursingFee;

    @Column(name = "others_fee")
    private double othersFee;

    @Column(name = "room_fee")
    private double roomFee;

    @Column(name = "status")
    private String status;

    @Column(name = "surgery_fee")
    private double surgeryFee;

    @Formula("surgeryFee + roomFee + othersFee +nursingFee + medicineFee + doctorFee")
    @Column(name = "total_claim_amount")
    private double totalClaimAmount;

    @Column(name = "xray_fee")
    private double xrayFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private PolicyDetail policyDetail;

    @Transient
    private Long policyId;

    public boolean isMoreDetailsStatus() {
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

    public double getDoctorFee() {
        return this.doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public String getHospitalDetails() {
        return this.hospitalDetails;
    }

    public void setHospitalDetails(String hospitalDetails) {
        this.hospitalDetails = hospitalDetails;
    }

    public double getMedicineFee() {
        return this.medicineFee;
    }

    public void setMedicineFee(double medicineFee) {
        this.medicineFee = medicineFee;
    }

    public String getMoreDetails() {
        return this.moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public boolean getMoreDetailsStatus() {
        return this.moreDetailsStatus;
    }

    public void setMoreDetailsStatus(boolean moreDetailsStatus) {
        this.moreDetailsStatus = moreDetailsStatus;
    }

    public double getNursingFee() {
        return this.nursingFee;
    }

    public void setNursingFee(double nursingFee) {
        this.nursingFee = nursingFee;
    }

    public double getOthersFee() {
        return this.othersFee;
    }

    public void setOthersFee(double othersFee) {
        this.othersFee = othersFee;
    }

    public double getRoomFee() {
        return this.roomFee;
    }

    public void setRoomFee(double roomFee) {
        this.roomFee = roomFee;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSurgeryFee() {
        return this.surgeryFee;
    }

    public void setSurgeryFee(double surgeryFee) {
        this.surgeryFee = surgeryFee;
    }

    public double getTotalClaimAmount() {
        return this.totalClaimAmount;
    }

    public void setTotalClaimAmount(double totalClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
    }

    public double getXrayFee() {
        return this.xrayFee;
    }

    public void setXrayFee(double xrayFee) {
        this.xrayFee = xrayFee;
    }

    public PolicyDetail getPolicyDetail() {
        return this.policyDetail;
    }

    public void setPolicyDetail(PolicyDetail policyDetail) {
        this.policyDetail = policyDetail;
    }

}
