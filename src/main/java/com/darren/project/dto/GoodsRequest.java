package com.darren.project.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoodsRequest {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotBlank
    private String description;
    @NotBlank
    private String brand;
    @NotBlank
    private String cpuBrand;
    @NotBlank
    private String cpuType;
    @NotBlank
    private String memoryCapacity;

    private String hdCapacity;
    @NotBlank
    private String cardModel;
    @NotBlank
    private String displaysize;

    private String image;



}
