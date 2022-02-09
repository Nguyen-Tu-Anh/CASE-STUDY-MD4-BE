package com.codegym.casestudy.service.impl;


import com.codegym.casestudy.model.Users;
import com.codegym.casestudy.repository.IUserRepositoty;
import com.codegym.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepositoty userRepositoty;

    @PersistenceContext
    EntityManager em;

    @Override
    public Optional<Users> findByUserName(String username) {
        return userRepositoty.findByUsername(username);
    }

    @Override
    public Boolean existsByUserName(String username) {
        return userRepositoty.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepositoty.existsByEmail(email);
    }

    @Override
    public Users save(Users users) {
        return userRepositoty.save(users);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        em.joinTransaction();
        userRepositoty.deleteById(id);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepositoty.findById(id);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return userRepositoty.findAll(pageable);
    }


    @Override
    public List<Users> findUsersByIdIsNotLike(Long id) {
        return userRepositoty.findUsersByIdIsNotLike(id);
    }

    @Override
    public int countUsers() {
        return userRepositoty.countUsers();
    }

}
