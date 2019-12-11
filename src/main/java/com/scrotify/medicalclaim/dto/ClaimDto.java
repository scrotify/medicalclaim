package com.scrotify.medicalclaim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class ClaimDto {

    private LocalDate admissionDate;

    private String aliment;

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
