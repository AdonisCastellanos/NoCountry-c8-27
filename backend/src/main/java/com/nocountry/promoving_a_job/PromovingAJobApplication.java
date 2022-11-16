package com.nocountry.promoving_a_job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PromovingAJobApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PromovingAJobApplication.class, args);
    }

}
