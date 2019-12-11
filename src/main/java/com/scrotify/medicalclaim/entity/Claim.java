package com.scrotify.medicalclaim.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


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
    private String claimId;

    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "aliment")
    private String aliment;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "discharge_date")
    private Date dischargeDate;

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
    private byte moreDetailsStatus;

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

    @Column(name = "total_claim_amount")
    private double totalClaimAmount;

    @Column(name = "xray_fee")
    private double xrayFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private PolicyDetail policyDetail;

    public Claim() {
    }

    public String getClaimId() {
        return this.claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public Date getAdmissionDate() {
        return this.admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
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

    public Date getDischargeDate() {
        return this.dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
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

    public byte getMoreDetailsStatus() {
        return this.moreDetailsStatus;
    }

    public void setMoreDetailsStatus(byte moreDetailsStatus) {
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
