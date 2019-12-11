package com.scrotify.medicalclaim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.Approver;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, Long>{

}
