package com.codegym.casestudy.service;



import com.codegym.casestudy.model.Role;
import com.codegym.casestudy.model.RoleName;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> findAll();
    Optional<Role> findByName(RoleName name);

}
