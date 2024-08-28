package com.darren.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class CustomersRegisterRequest {
    @NotBlank(message = "用户名不能為空")
    private String name;
    @NotBlank(message = "密碼不能為空")
    private String password;
    @NotBlank(message = "住址不能為空")
    private String address;
    @NotBlank(message = "電話不能為空")
    private String phone;
    @NotBlank(message = "生日不能為空")
    private String birthday;
}