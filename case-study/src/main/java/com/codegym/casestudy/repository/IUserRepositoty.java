package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepositoty extends JpaRepository<Users, Long> {
    List<Users> findUsersByIdIsNotLike(Long id);
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query(nativeQuery = true, value = "select count(id) from users")
    int countUsers();
}
