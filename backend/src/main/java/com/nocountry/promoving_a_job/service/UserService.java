package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.dto.UserDTO;
import java.util.List;


public interface UserService {


    List<UserDTO> findAll() ;

    UserDTO get(final Long id) ;

    Long create(final UserDTO userDTO) ;

    void update(final Long id, final UserDTO userDTO) ;

    void delete(final Long id);

    boolean emailExists(final String email);

}
