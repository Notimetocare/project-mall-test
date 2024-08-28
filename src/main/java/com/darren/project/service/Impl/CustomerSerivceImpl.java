package com.darren.project.service.Impl;

import com.darren.project.dao.CustomersDao;
import com.darren.project.dto.CustomersRegisterRequest;
import com.darren.project.entity.Customers;
import com.darren.project.service.CustomerSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;

@Service
public class CustomerSerivceImpl implements CustomerSerivce {
    @Autowired
    private CustomersDao customersDao;

    @Override
    public Integer register(CustomersRegisterRequest customersRegisterRequest) throws ParseException {
            Customers customersPhone = customersDao.getCustomersByphone(customersRegisterRequest.getPhone());

            //檢查電話是否已被註冊
            if(customersPhone != null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"電話號碼已註冊");
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
}
