package com.scrotify.medicalclaim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.PolicyDetail;
@Repository
public interface PolicyDetailRepository extends JpaRepository<PolicyDetail, Long> {

	Optional<PolicyDetail> findByPolicyId(Long policyId);
}
