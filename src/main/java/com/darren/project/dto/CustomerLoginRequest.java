package com.darren.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerLoginRequest {
    @NotBlank(message = "用户名不能為空")
    private String account;
    @NotBlank(message = "密碼不能為空")
    private String password;
}
