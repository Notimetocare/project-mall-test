package com.darren.project.dto;

import lombok.Data;

@Data
public class GoodsQueryParams {
    private String search;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;
}
