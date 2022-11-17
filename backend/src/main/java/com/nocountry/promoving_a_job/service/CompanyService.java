package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.dto.CompanyDTO;

import java.util.List;



public interface CompanyService {

    List<CompanyDTO> findAll();

    CompanyDTO get(final Long id);

    Long create(final CompanyDTO companyDTO);

    void update(final Long id, final CompanyDTO companyDTO);

    void delete(final Long id);

}
