package com.nocountry.promoving_a_job.repository;

import com.nocountry.promoving_a_job.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}
