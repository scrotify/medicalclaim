package com.scrotify.medicalclaim.repository;

import com.scrotify.medicalclaim.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {



}
