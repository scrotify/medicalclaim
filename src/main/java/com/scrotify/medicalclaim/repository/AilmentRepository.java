package com.scrotify.medicalclaim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scrotify.medicalclaim.entity.Ailment;

@Repository
public interface AilmentRepository extends JpaRepository<Ailment , Long>{

}
