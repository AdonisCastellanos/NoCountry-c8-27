package com.nocountry.promoving_a_job.repository;

import com.nocountry.promoving_a_job.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Long> {
}