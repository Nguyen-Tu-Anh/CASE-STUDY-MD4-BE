package com.codegym.casestudy.service.impl;


import com.codegym.casestudy.model.Role;
import com.codegym.casestudy.model.RoleName;
import com.codegym.casestudy.repository.IRoleRepository;
import com.codegym.casestudy.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
