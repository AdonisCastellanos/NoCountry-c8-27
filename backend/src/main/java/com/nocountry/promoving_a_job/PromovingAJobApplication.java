package com.nocountry.promoving_a_job;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "Promoving a Job API", version = "0.1", description = "Application EndPoints information"))
public class PromovingAJobApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PromovingAJobApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
