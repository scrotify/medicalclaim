package com.scrotify.medicalclaim.repository;

import com.scrotify.medicalclaim.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
