package com.darren.project.controller;

import com.darren.project.dto.CustomersRegisterRequest;

import com.darren.project.entity.Customers;
import com.darren.project.service.CustomerSerivce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class CustomersController {
    @Autowired
    private CustomerSerivce customerSerivce;

    @PostMapping("customers/register")
    public ResponseEntity<Customers> register(@RequestBody @Valid CustomersRegisterRequest customersRegisterRequest) throws ParseException {
        Integer customersId = customerSerivce.register(customersRegisterRequest);

        Customers customers = customerSerivce.getCustomersById(customersId);

        return ResponseEntity.status(HttpStatus.CREATED).body(customers);
    }

    @GetMapping("/customers/checkAccountUsed")
    public ResponseEntity<Customers> checkAccountUsed(@RequestParam @Valid String account) {
        Customers customers = customerSerivce.getCustomersByAccount(account);

        if (null != customers) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
