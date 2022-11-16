package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.dto.UserDTO;
import java.util.List;


public interface UserService {


    public List<UserDTO> findAll() ;

    public UserDTO get(final Long id) ;

    public Long create(final UserDTO userDTO) ;

    public void update(final Long id, final UserDTO userDTO) ;

    public void delete(final Long id);

    public boolean emailExists(final String email);

}
