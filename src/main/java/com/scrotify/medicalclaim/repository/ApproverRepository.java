package com.scrotify.medicalclaim.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.Approver;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, Long>{



	Optional<Approver> findByApproverEmail(String email);

	Optional<Approver> findByApproverId(Long approverId);
	
	

}
