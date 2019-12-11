package com.scrotify.medicalclaim.service;

import com.scrotify.medicalclaim.dto.ApiResponse;
import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.PolicyDetail;
import com.scrotify.medicalclaim.repository.ClaimRepository;
import com.scrotify.medicalclaim.repository.PolicyDetailRepository;
import com.scrotify.medicalclaim.util.MedicalClaimConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ClaimService {
    public ApiResponse postClaims(Claim claim);
}
