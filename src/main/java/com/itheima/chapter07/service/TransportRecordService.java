package com.itheima.chapter07.service;


import com.itheima.chapter07.entity.TransportRecord;
import com.itheima.chapter07.repository.TransportRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportRecordService {
    @Autowired
    private TransportRecordRepository transportRecordRepository;

//    public TransportRecord saveTransportRecord(TransportRecord record) {
//        return transportRecordRepository.save(record);
//    }

    public List<TransportRecord> getAllRecords() {
        return transportRecordRepository.findAll();
    }
//    public List<MonthlyQuantityDTO> getMonthlyQuantity(Integer year) {
//        return transportRecordRepository.sumQuantityByMonth(year); // 这里的repository已被初始化
//    }
//    public Optional<TransportRecord> getRecordById(Long id) {
//        return transportRecordRepository.findById(id);
//    }
//
//    public void deleteRecord(Long id) {
//        transportRecordRepository.deleteById(id);
//    }
//
//    public List<TransportRecord> getRecordsByDateRange(Date startDate, Date endDate) {
//        return transportRecordRepository.findByTransportDateBetween(startDate, endDate);
//    }
//
//    public List<TransportRecord> getRecordsByCoalMine(Long coalMineId) {
//        return transportRecordRepository.findByCoalMineId(coalMineId);
//    }
//
//    public List<TransportRecord> getRecordsByTransportCompany(Long transportCompanyId) {
//        return transportRecordRepository.findByTransportCompanyId(transportCompanyId);
//    }
}    