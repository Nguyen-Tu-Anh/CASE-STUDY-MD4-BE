package com.codegym.casestudy.repository;


import com.codegym.casestudy.model.Role;
import com.codegym.casestudy.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
