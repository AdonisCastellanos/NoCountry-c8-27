package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.dto.CommentDTO;

import java.util.List;


public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO get(final Long id);

    Long create(final CommentDTO commentDTO);
    void update(final Long id, final CommentDTO commentDTO);

    void delete(final Long id);

}
