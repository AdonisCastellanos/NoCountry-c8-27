package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.entity.Company;
import com.nocountry.promoving_a_job.entity.JobOffer;
import com.nocountry.promoving_a_job.dto.JobOfferDTO;
import com.nocountry.promoving_a_job.repository.JobOfferRepository;
import com.nocountry.promoving_a_job.repository.CompanyRepository;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class JobOfferServiceImp implements JobOfferService{

    private final JobOfferRepository jobOfferRepository;

    private final CompanyRepository companyRepository;

    public List<JobOfferDTO> findAll() {
        return jobOfferRepository.findAll(Sort.by("id"))
                .stream()
                .map(jobOffer -> mapToDTO(jobOffer, new JobOfferDTO()))
                .collect(Collectors.toList());
    }

    public JobOfferDTO get(final Long id) {
        return jobOfferRepository.findById(id)
                .map(jobOffer -> mapToDTO(jobOffer, new JobOfferDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final JobOfferDTO jobOfferDTO) {
        final JobOffer jobOffer = new JobOffer();
        mapToEntity(jobOfferDTO, jobOffer);
        return jobOfferRepository.save(jobOffer).getId();
    }

    public void update(final Long id, final JobOfferDTO jobOfferDTO) {
        final JobOffer jobOffer = jobOfferRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(jobOfferDTO, jobOffer);
        jobOfferRepository.save(jobOffer);
    }

    public void delete(final Long id) {
        jobOfferRepository.deleteById(id);
    }

    private JobOfferDTO mapToDTO(final JobOffer jobOffer, final JobOfferDTO jobOfferDTO) {
        jobOfferDTO.setId(jobOffer.getId());
        jobOfferDTO.setTitle(jobOffer.getTitle());
        jobOfferDTO.setPosition(jobOffer.getPosition());
        jobOfferDTO.setDescription(jobOffer.getDescription());
        jobOfferDTO.setMinSalary(jobOffer.getMinSalary());
        jobOfferDTO.setMaxSalary(jobOffer.getMaxSalary());
        jobOfferDTO.setExpirationDate(jobOffer.getExpirationDate());
        jobOfferDTO.setCompany(jobOffer.getCompany().getId());
        return jobOfferDTO;
    }

    private JobOffer mapToEntity(final JobOfferDTO jobOfferDTO, final JobOffer jobOffer) {
        jobOffer.setTitle(jobOfferDTO.getTitle());
        jobOffer.setPosition(jobOfferDTO.getPosition());
        jobOffer.setDescription(jobOfferDTO.getDescription());
        jobOffer.setMinSalary(jobOfferDTO.getMinSalary());
        jobOffer.setMaxSalary(jobOfferDTO.getMaxSalary());
        jobOffer.setExpirationDate(jobOfferDTO.getExpirationDate());
        final Company company = jobOfferDTO.getCompany() == null ? null : companyRepository.findById(jobOfferDTO.getCompany())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "job offer company not found"));
        jobOffer.setCompany(company);
        return jobOffer;
    }

}
