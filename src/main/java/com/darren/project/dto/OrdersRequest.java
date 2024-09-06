package com.darren.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrdersRequest {
    @NotNull
    private Integer status;
    @NotNull
    private BigDecimal total;



}
