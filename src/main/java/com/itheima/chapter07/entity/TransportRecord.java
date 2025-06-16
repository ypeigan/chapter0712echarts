package com.itheima.chapter07.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Entity
public class TransportRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long coalMineId;
    private Long transportCompanyId;
    private double quantity;
    private Date transportDate;
//    private String vehicleNumber;
//    private String driverName;
//    private double transportFee;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoalMineId() {
        return coalMineId;
    }

    public void setCoalMineId(Long coalMineId) {
        this.coalMineId = coalMineId;
    }

    public Long getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(Long transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(Date transportDate) {
        this.transportDate = transportDate;
    }


//    public String getVehicleNumber() {
//        return vehicleNumber;
//    }
//
//    public void setVehicleNumber(String vehicleNumber) {
//        this.vehicleNumber = vehicleNumber;
//    }

//    public String getDriverName() {
//        return driverName;
//    }
//
//    public void setDriverName(String driverName) {
//        this.driverName = driverName;
//    }

//    public double getTransportFee() {
//        return transportFee;
//    }
//
//    public void setTransportFee(double transportFee) {
//        this.transportFee = transportFee;
//    }
}