package com.nocountry.promoving_a_job.repository;

import com.nocountry.promoving_a_job.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByCompany(Long companyId);

}
