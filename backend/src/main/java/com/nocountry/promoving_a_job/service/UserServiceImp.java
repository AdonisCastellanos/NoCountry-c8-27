package com.nocountry.promoving_a_job.service;

import com.nocountry.promoving_a_job.entity.Company;
import com.nocountry.promoving_a_job.entity.User;
import com.nocountry.promoving_a_job.dto.UserDTO;
import com.nocountry.promoving_a_job.repository.CompanyRepository;
import com.nocountry.promoving_a_job.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Transactional
@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserServiceImp(final UserRepository userRepository,
                          final CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll(Sort.by("id"))
                .stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setCountry(user.getCountry());
        userDTO.setUserCompanys(user.getUserCompanyCompanys() == null ? null : user.getUserCompanyCompanys().stream()
                .map(company -> company.getId())
                .collect(Collectors.toList()));
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setCountry(userDTO.getCountry());
        final List<Company> userCompanys = companyRepository.findAllById(
                userDTO.getUserCompanys() == null ? Collections.emptyList() : userDTO.getUserCompanys());
        if (userCompanys.size() != (userDTO.getUserCompanys() == null ? 0 : userDTO.getUserCompanys().size())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of userCompanys not found");
        }
        user.setUserCompanyCompanys(userCompanys.stream().collect(Collectors.toSet()));
        return user;
    }

    public boolean emailExists(final String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

}
