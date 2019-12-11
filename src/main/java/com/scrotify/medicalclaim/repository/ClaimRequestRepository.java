package com.scrotify.medicalclaim.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.ClaimRequest;
@Repository
public interface ClaimRequestRepository extends JpaRepository<ClaimRequest, Long>{

	List<ClaimRequest> findAllByApproverId(Long approverId);

	Optional<ClaimRequest> findByClaimRequestId(Long claimRequestID);

}
