package com.itheima.chapter07.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CoalMine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mineName;
    private String location;
    private double coalReserves;
    private String contactPerson;
    private String phone;
    private String shengfen;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMineName() {
        return mineName;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCoalReserves() {
        return coalReserves;
    }

    public void setCoalReserves(double coalReserves) {
        this.coalReserves = coalReserves;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setShengfen(String shengfen) {
        this.shengfen = shengfen;
    }

    public String getShengfen() {
        return shengfen;
    }
}