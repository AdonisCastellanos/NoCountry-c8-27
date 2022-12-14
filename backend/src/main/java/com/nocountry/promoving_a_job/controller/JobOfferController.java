package com.nocountry.promoving_a_job.controller;

import com.nocountry.promoving_a_job.dto.JobOfferDTO;
import com.nocountry.promoving_a_job.service.JobOfferService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/jobOffers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class JobOfferController {

    private final JobOfferService jobOfferService;


    @GetMapping
    public ResponseEntity<List<JobOfferDTO>> getAllJobOffers() {
        return ResponseEntity.ok(jobOfferService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobOfferDTO> getJobOffer(@PathVariable final Long id) {
        return ResponseEntity.ok(jobOfferService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createJobOffer(@RequestBody @Valid final JobOfferDTO jobOfferDTO) {
        return new ResponseEntity<>(jobOfferService.create(jobOfferDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateJobOffer(@PathVariable final Long id,
            @RequestBody @Valid final JobOfferDTO jobOfferDTO) {
        jobOfferService.update(id, jobOfferDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteJobOffer(@PathVariable final Long id) {
        jobOfferService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
