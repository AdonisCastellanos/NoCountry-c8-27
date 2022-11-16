package com.nocountry.promoving_a_job.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String country;

    @NotNull
    @Size(max = 255)
    private String city;

    @NotNull
    @Size(max = 255)
    private String address;

    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private String phone;

    @Size(max = 255)
    private String logo;

    private Integer validation;

    @NotNull
    private Long offerCompany;

}
