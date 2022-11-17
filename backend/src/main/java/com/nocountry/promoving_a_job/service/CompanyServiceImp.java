package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.entity.Company;
import com.nocountry.promoving_a_job.entity.JobOffer;
import com.nocountry.promoving_a_job.dto.CompanyDTO;
import com.nocountry.promoving_a_job.repository.CompanyRepository;
import com.nocountry.promoving_a_job.repository.JobOfferRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService{

    private final CompanyRepository companyRepository;
    private final JobOfferRepository jobOfferRepository;

    public List<CompanyDTO> findAll() {
        return companyRepository.findAll(Sort.by("id"))
                .stream()
                .map(company -> mapToDTO(company, new CompanyDTO()))
                .collect(Collectors.toList());
    }

    public CompanyDTO get(final Long id) {
        return companyRepository.findById(id)
                .map(company -> mapToDTO(company, new CompanyDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CompanyDTO companyDTO) {
        final Company company = new Company();
        mapToEntity(companyDTO, company);
        return companyRepository.save(company).getId();
    }

    public void update(final Long id, final CompanyDTO companyDTO) {
        final Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(companyDTO, company);
        companyRepository.save(company);
    }

    public void delete(final Long id) {
        companyRepository.deleteById(id);
    }

    private CompanyDTO mapToDTO(final Company company, final CompanyDTO companyDTO) {
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setCountry(company.getCountry());
        companyDTO.setCity(company.getCity());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setEmail(company.getEmail());
        companyDTO.setPhone(company.getPhone());
        companyDTO.setLogo(company.getLogo());
        companyDTO.setValidation(company.getValidation());
        companyDTO.setJobOffers(company.getJobOffers() == null ? null : company.getJobOffers().stream()
                .map(offer -> offer.getId())
                .collect(Collectors.toList()));
        return companyDTO;
    }

    private Company mapToEntity(final CompanyDTO companyDTO, final Company company) {
        company.setName(companyDTO.getName());
        company.setCountry(companyDTO.getCountry());
        company.setCity(companyDTO.getCity());
        company.setAddress(companyDTO.getAddress());
        company.setEmail(companyDTO.getEmail());
        company.setPhone(companyDTO.getPhone());
        company.setLogo(companyDTO.getLogo());
        company.setValidation(companyDTO.getValidation());

        final List<JobOffer> offersCompany = jobOfferRepository.findAllById(
                companyDTO.getJobOffers() == null ? Collections.emptyList() : companyDTO.getJobOffers());
        if (offersCompany.size() != (companyDTO.getJobOffers() == null ? 0 : companyDTO.getJobOffers().size())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of company offers not found");
        }
        company.setJobOffers(offersCompany.stream().collect(Collectors.toSet()));
        return company;
    }

}
