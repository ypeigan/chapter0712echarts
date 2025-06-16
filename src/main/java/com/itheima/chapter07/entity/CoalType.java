package com.itheima.chapter07.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//@Table(name = "coal_types")
public class CoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coal_name")
    private String coalName;

    @Column(name = "type")
    private String coalType;

    @Column(name = "calorific_value")
    private Integer calorificValue;

    @Column(name = "ash_content")
    private BigDecimal ashContent;

    @Column(name = "sulfur_content")
    private BigDecimal sulfurContent;

    @Column(name = "moisture_content")
    private BigDecimal moistureContent;

    private BigDecimal price;

    private String origin;

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoalName() {
        return coalName;
    }

    public void setCoalName(String coalName) {
        this.coalName = coalName;
    }

    public String getCoalType() {
        return coalType;
    }

    public void setCoalType(String coalType) {
        this.coalType = coalType;
    }

    public Integer getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(Integer calorificValue) {
        this.calorificValue = calorificValue;
    }

    public BigDecimal getAshContent() {
        return ashContent;
    }

    public void setAshContent(BigDecimal ashContent) {
        this.ashContent = ashContent;
    }

    public BigDecimal getSulfurContent() {
        return sulfurContent;
    }

    public void setSulfurContent(BigDecimal sulfurContent) {
        this.sulfurContent = sulfurContent;
    }

    public BigDecimal getMoistureContent() {
        return moistureContent;
    }

    public void setMoistureContent(BigDecimal moistureContent) {
        this.moistureContent = moistureContent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
