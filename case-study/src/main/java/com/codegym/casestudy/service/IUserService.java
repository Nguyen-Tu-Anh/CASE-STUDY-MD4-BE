package com.codegym.casestudy.service;





import com.codegym.casestudy.model.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<Users> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    Users save(Users users);
    void deleteById(Long id);
    Optional<Users> findById(Long id);
    List<Users> findAll();
    List<Users> findUsersByIdIsNotLike(Long id);
}
