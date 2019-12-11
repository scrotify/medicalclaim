package com.scrotify.medicalclaim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.Approver;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, Long> {

	Optional<Approver> findByApproverId(Long approverId);
	
	Optional<Approver> findByApproverEmail(String email);
	
	
}
