package com.darren.project.controller;

import com.darren.project.dto.CustomersRegisterRequest;

import com.darren.project.entity.Customers;
import com.darren.project.service.CustomerService;

import com.darren.project.util.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RestController
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers/register")
    public ResponseEntity register(@ModelAttribute @Valid CustomersRegisterRequest customersRegisterRequest) throws ParseException {
        Integer customersId = customerService.register(customersRegisterRequest);

        if(customersId != null){

            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header("Location", "/login.html").build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping(value = "/customers/checkAccountUsed")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Result> checkAccountUsed(@RequestParam("account") String account) {
        System.out.println("Received account" + account);
        Customers customers = customerService.getCustomersByAccount(account);


        Result result = (customers != null)
                ? Result.error("帳戶已被使用")
                : Result.ok("帳戶可用");

        // Return the response
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)  // Set Content-Type header
                .body(result);
    }
}
