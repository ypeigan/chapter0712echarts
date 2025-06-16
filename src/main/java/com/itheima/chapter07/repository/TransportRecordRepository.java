//package com.itheima.chapter07.repository;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import com.itheima.chapter07.entity.TransportRecord;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Date;
//import java.util.List;
//@Mapper
//public interface TransportRecordRepository extends JpaRepository<TransportRecord, Long> {
////    List<TransportRecord> findByTransportDateBetween(Date startDate, Date endDate);
////    List<TransportRecord> findByCoalMineId(Long coalMineId);
////    List<TransportRecord> findByTransportCompanyId(Long transportCompanyId);
//@Select("""
//        SELECT
//            MONTH(transport_date) AS month,
//            SUM(quantity) AS total_quantity
//        FROM transport_records
//        WHERE YEAR(transport_date) = #{year}
//          AND MONTH(transport_date) BETWEEN 1 AND 5
//        GROUP BY MONTH(transport_date)
//        ORDER BY MONTH(transport_date);
//    """)
//List<MonthlyQuantityDTO> sumQuantityByMonth(Integer year);
//}

package com.itheima.chapter07.repository;

import com.itheima.chapter07.entity.TransportRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRecordRepository extends JpaRepository<TransportRecord, Long> {

//    @Query(value = """
//        SELECT
//            MONTH(t.transportDate) AS month,
//            SUM(t.quantity) AS totalQuantity
//        FROM TransportRecord t
//        WHERE YEAR(t.transportDate) = :year
//          AND MONTH(t.transportDate) BETWEEN 1 AND 5
//        GROUP BY MONTH(t.transportDate)
//        ORDER BY MONTH(t.transportDate)
//    """, nativeQuery = true)
//    List<MonthlyQuantityDTO> sumQuantityByMonth(Integer year);
}