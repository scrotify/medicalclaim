package com.scrotify.medicalclaim.repository;

import com.scrotify.medicalclaim.entity.Claim;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Optional<Claim> findByClaimId(Long claimId);

}
