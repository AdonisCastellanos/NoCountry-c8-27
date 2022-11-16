package com.nocountry.promoving_a_job.repository;

import com.nocountry.promoving_a_job.entity.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
