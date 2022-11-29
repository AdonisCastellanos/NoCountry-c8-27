package com.nocountry.promoving_a_job.repository;

import com.nocountry.promoving_a_job.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsUserByIdAndEmail(Long id,String email);

    //boolean existsUserWithAdminRoleByEmail(Long id, String email);
}
