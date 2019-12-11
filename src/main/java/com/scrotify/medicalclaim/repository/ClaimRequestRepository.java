package com.scrotify.medicalclaim.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.Claim;
import com.scrotify.medicalclaim.entity.ClaimRequest;

@Repository
public interface ClaimRequestRepository extends JpaRepository<ClaimRequest, Long> {
	
	Optional<Claim> findByClaimId(Long claimId);
        Optional<ClaimRequest> findByClaimRequestId(Long claimRequestID);
	List<ClaimRequest> findAllByApproverRole(String approverRole);


}
