package com.darren.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddGoodsRequest {
    @NotNull
    private Integer goodsId;
    @NotBlank
    private String goodsName;
    @NotNull
    private Double goodsPrice;

    private Integer quantity;

}
