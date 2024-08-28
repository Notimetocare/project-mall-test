package com.darren.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 20)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "address", nullable = true, length = 100)
    private String address;
    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Basic
    @Column(name = "birthday", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Long birthday;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    // Convert birthday to Date
    public Date getBirthdayAsDate() {
        return birthday != null ? new Date(birthday) : null;
    }

    // Set birthday from Date
    public void setBirthdayFromDate(Date date) {
        this.birthday = date != null ? date.getTime() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(id, customers.id) && Objects.equals(name, customers.name) && Objects.equals(password, customers.password) && Objects.equals(address, customers.address) && Objects.equals(phone, customers.phone) && Objects.equals(birthday, customers.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, address, phone, birthday);
    }
}
