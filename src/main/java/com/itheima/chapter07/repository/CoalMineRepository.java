package com.itheima.chapter07.repository;

import com.itheima.chapter07.entity.CoalMine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoalMineRepository extends JpaRepository<CoalMine, Long> {
//    List<CoalMine> findByLocation(String location);
}    