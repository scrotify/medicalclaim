package com.scrotify.medicalclaim.repository;

import com.scrotify.medicalclaim.entity.PolicyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PolicyDetailRepository extends JpaRepository<PolicyDetail, Long> {

}
