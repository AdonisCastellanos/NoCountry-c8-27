package com.nocountry.promoving_a_job.repository;

import com.nocountry.promoving_a_job.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailIgnoreCase(String email);

}
