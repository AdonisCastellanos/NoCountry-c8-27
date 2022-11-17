package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.entity.Comment;
import com.nocountry.promoving_a_job.entity.Company;
import com.nocountry.promoving_a_job.entity.User;
import com.nocountry.promoving_a_job.dto.CommentDTO;
import com.nocountry.promoving_a_job.repository.CommentRepository;
import com.nocountry.promoving_a_job.repository.CompanyRepository;
import com.nocountry.promoving_a_job.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class CommentServiceImp implements CommentService{

    private final CommentRepository commentRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;


    public List<CommentDTO> findAll() {
        return commentRepository.findAll(Sort.by("id"))
                .stream()
                .map(comment -> mapToDTO(comment, new CommentDTO()))
                .collect(Collectors.toList());
    }

    public CommentDTO get(final Long id) {
        return commentRepository.findById(id)
                .map(comment -> mapToDTO(comment, new CommentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CommentDTO commentDTO) {
        final Comment comment = new Comment();
        mapToEntity(commentDTO, comment);
        return commentRepository.save(comment).getId();
    }

    public void update(final Long id, final CommentDTO commentDTO) {
        final Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(commentDTO, comment);
        commentRepository.save(comment);
    }

    public void delete(final Long id) {
        commentRepository.deleteById(id);
    }

    private CommentDTO mapToDTO(final Comment comment, final CommentDTO commentDTO) {
        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        commentDTO.setRate(comment.getRate());
        commentDTO.setCompany(comment.getCompany() == null ? null : comment.getCompany().getId());
        commentDTO.setUser(comment.getUser() == null ? null : comment.getUser().getId());
        return commentDTO;
    }

    private Comment mapToEntity(final CommentDTO commentDTO, final Comment comment) {
        comment.setBody(commentDTO.getBody());
        comment.setRate(commentDTO.getRate());
        final Company company = commentDTO.getCompany() == null ? null : companyRepository.findById(commentDTO.getCompany())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "companyComments not found"));
        comment.setCompany(company);
        final User user = commentDTO.getUser() == null ? null : userRepository.findById(commentDTO.getUser())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "userComments not found"));
        comment.setUser(user);
        return comment;
    }

}
