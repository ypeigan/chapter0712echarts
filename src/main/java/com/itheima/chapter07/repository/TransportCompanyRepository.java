package com.itheima.chapter07.repository;

import com.itheima.chapter07.entity.TransportCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportCompanyRepository extends JpaRepository<TransportCompany, Long> {
//    List<TransportCompany> findByLocation(String location);
}    