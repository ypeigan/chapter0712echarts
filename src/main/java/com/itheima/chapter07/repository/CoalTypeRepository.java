package com.itheima.chapter07.repository;

import com.itheima.chapter07.entity.CoalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoalTypeRepository extends JpaRepository<CoalType, Integer> {
     //根据煤类型查询
    List<CoalType> findByCoalType(String coalType);

    // 根据发热量范围查询
    List<CoalType> findByCalorificValueBetween(int min, int max);

    // 根据价格范围查询
    List<CoalType> findByPriceBetween(double min, double max);

    List<CoalType> findByCoalTypeIn(List<String> types);

    // 查询每种类型的煤的平均价格
    @Query("SELECT c.coalType, AVG(c.price) FROM CoalType c GROUP BY c.coalType")
    List<Object[]> findAveragePriceByType();
}
