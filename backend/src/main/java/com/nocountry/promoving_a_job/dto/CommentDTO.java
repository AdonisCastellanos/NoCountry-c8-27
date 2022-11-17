package com.nocountry.promoving_a_job.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommentDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String body;

    @NotNull
    private Integer rate;

    @NotNull
    private Long company;

    private Long user;

}
