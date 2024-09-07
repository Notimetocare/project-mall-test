package com.darren.project.service;

import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;

import java.text.ParseException;


public interface CustomerSerivce {
    Integer register(CustomersRegisterRequest customersRegisterRequest) throws ParseException;

    Customers getCustomersById(Integer customersId);


    Customers getCustomersByAccount(String acc);
}
