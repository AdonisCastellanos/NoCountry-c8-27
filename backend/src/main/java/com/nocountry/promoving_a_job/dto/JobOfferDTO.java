package com.nocountry.promoving_a_job.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JobOfferDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    @Size(max = 255)
    private String position;

    @NotNull
    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private String minSalary;

    @Size(max = 255)
    private String maxSalary;

    @Size(max = 255)
    private String expirationDate;


    @NotNull
    private Long company;

}
