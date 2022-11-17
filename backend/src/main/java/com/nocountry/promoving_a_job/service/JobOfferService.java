package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.dto.JobOfferDTO;

import java.util.List;



public interface JobOfferService {

    List<JobOfferDTO> findAll();

    JobOfferDTO get(final Long id);

    Long create(final JobOfferDTO jobOfferDTO) ;

    void update(final Long id, final JobOfferDTO jobOfferDTO);

    void delete(final Long id);


}
