package com.darren.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Goods {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @Basic
    @Column(name = "description", nullable = true, length = 200)
    private String description;
    @Basic
    @Column(name = "brand", nullable = true, length = 30)
    private String brand;
    @Basic
    @Column(name = "cpu_brand", nullable = true, length = 30)
    private String cpuBrand;
    @Basic
    @Column(name = "cpu_type", nullable = true, length = 30)
    private String cpuType;
    @Basic
    @Column(name = "memory_capacity", nullable = true, length = 30)
    private String memoryCapacity;
    @Basic
    @Column(name = "hd_capacity", nullable = true, length = 30)
    private String hdCapacity;
    @Basic
    @Column(name = "card_model", nullable = true, length = 30)
    private String cardModel;
    @Basic
    @Column(name = "displaySize", nullable = true, length = 30)
    private String displaySize;
    @Basic
    @Column(name = "image", nullable = true, length = 100)
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpuBrand() {
        return cpuBrand;
    }

    public void setCpuBrand(String cpuBrand) {
        this.cpuBrand = cpuBrand;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(String memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public String getHdCapacity() {
        return hdCapacity;
    }

    public void setHdCapacity(String hdCapacity) {
        this.hdCapacity = hdCapacity;
    }

    public String getCardModel() {
        return cardModel;
    }

    public void setCardModel(String cardModel) {
        this.cardModel = cardModel;
    }

    public String getDisplaySize() {
        return this.displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) && Objects.equals(name, goods.name) && Objects.equals(price, goods.price) && Objects.equals(description, goods.description) && Objects.equals(brand, goods.brand) && Objects.equals(cpuBrand, goods.cpuBrand) && Objects.equals(cpuType, goods.cpuType) && Objects.equals(memoryCapacity, goods.memoryCapacity) && Objects.equals(hdCapacity, goods.hdCapacity) && Objects.equals(cardModel, goods.cardModel) && Objects.equals(displaySize, goods.displaySize) && Objects.equals(image, goods.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, brand, cpuBrand, cpuType, memoryCapacity, hdCapacity, cardModel, displaySize, image);
    }
}
