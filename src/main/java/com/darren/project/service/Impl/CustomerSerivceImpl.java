package com.darren.project.service.Impl;

import com.darren.project.dao.CustomersDao;
import com.darren.project.dto.CustomerLoginRequest;
import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;
import com.darren.project.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;

@Service
public class CustomerSerivceImpl implements CustomerService {
    @Autowired
    private CustomersDao customersDao;

    @Override
    public Integer register(CustomersRegisterRequest customersRegisterRequest) throws ParseException {
            Customers customersAccount = customersDao.getCustomersByAccount(customersRegisterRequest.getAccount());

            //檢查帳號是否已被註冊
            if(customersAccount != null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"帳號已註冊");
            }
        //使用MD5進行加密
        String hashPassword = DigestUtils.md5DigestAsHex(customersRegisterRequest.getPassword().getBytes());
        customersRegisterRequest.setPassword((hashPassword));
        //創建帳號
        return customersDao.creatCustomers(customersRegisterRequest);
    }

    @Override
    public Customers getCustomersById(Integer customersId) {
        return customersDao.getCustomersByCustomersId(customersId);
    }

    @Override
    public Customers getCustomersByAccount(String account) {

        return customersDao.getCustomersByAccount(account);
    }

    @Override
    public Customers login(CustomerLoginRequest customersLoginRequest) {

        Customers customers = customersDao.getCustomersByAccount(customersLoginRequest.getAccount());
        if(customers == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"帳號不存在");
        }
        //使用MD5進行加密
        String hashPassword = DigestUtils.md5DigestAsHex(customersLoginRequest.getPassword().getBytes());
        if(!hashPassword.equals(customers.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"密碼錯誤");
        }
        return customers;
    }

    @Override
    public Customers getCurrentCustomers(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            String account = authentication.getName();
            Customers customers = customersDao.getCustomersByAccount(account);

            if(customers == null){
                customers = (Customers)session.getAttribute("customers");
            }
            return customers;
        }
        return null;
    }


}
