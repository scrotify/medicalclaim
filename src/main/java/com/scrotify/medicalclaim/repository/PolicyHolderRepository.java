package com.scrotify.medicalclaim.repository;

import java.util.Optional;

import com.scrotify.medicalclaim.entity.PolicyHolder;

public interface PolicyHolderRepository {
	
	Optional<PolicyHolder> findByPolicyId(Long policyId);

}
