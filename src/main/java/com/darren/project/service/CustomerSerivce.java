package com.darren.project.service;

import com.darren.project.dao.CustomersDao;
import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;


public interface CustomerSerivce {
    Integer register(CustomersRegisterRequest customersRegisterRequest) throws ParseException;

    Customers getCustomersById(Integer customersId);
}
