package com.pixel.challenge.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixel.challenge.healthcare.model.Healthcareinstitution;

@Repository
public interface HealthcareInstitutionRepository extends JpaRepository<Healthcareinstitution, Long>{

}
