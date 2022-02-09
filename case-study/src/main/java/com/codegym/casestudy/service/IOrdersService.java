package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Orders;

import java.util.List;

public interface IOrdersService {
    void save(Orders orders);
    List<Orders> findAll();

}
