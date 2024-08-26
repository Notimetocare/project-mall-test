package com.darren.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Orderlineitems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "goodsid", nullable = false)
    private Integer goodsid;
    @Basic
    @Column(name = "orderid", nullable = false, length = 20)
    private String orderid;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "sub_total", nullable = true, precision = 0)
    private Double subTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderlineitems that = (Orderlineitems) o;
        return Objects.equals(id, that.id) && Objects.equals(goodsid, that.goodsid) && Objects.equals(orderid, that.orderid) && Objects.equals(quantity, that.quantity) && Objects.equals(subTotal, that.subTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodsid, orderid, quantity, subTotal);
    }
}
