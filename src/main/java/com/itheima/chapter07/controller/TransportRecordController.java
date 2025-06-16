package com.itheima.chapter07.controller;


import com.itheima.chapter07.entity.TransportRecord;
import com.itheima.chapter07.service.TransportRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TransportRecordController {
    @Autowired
    private TransportRecordService transportRecordService;

    @GetMapping("/transportrecords")
    public List<TransportRecord> getAllRecords() {
        List<TransportRecord> transportRecords = transportRecordService.getAllRecords();
//        return ResponseEntity.ok(transportRecords);
        return transportRecordService.getAllRecords();
    }

    // 获取指定年份1-5月的月度运输量
//    @GetMapping("/monthly-quantity")
//    public List<MonthlyQuantityDTO> getMonthlyQuantity(@RequestParam(defaultValue = "2025") Integer year) {
//        return transportRecordService.getMonthlyQuantity(year);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TransportRecord> getRecordById(@PathVariable Long id) {
//        Optional<TransportRecord> recordOptional = transportRecordService.getRecordById(id);
//        return recordOptional.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public TransportRecord createRecord(@RequestBody TransportRecord record) {
//        return transportRecordService.saveTransportRecord(record);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TransportRecord> updateRecord(@PathVariable Long id, @RequestBody TransportRecord recordDetails) {
//        Optional<TransportRecord> recordOptional = transportRecordService.getRecordById(id);
//        if (!recordOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        TransportRecord record = recordOptional.get();
//        record.setCoalMineId(recordDetails.getCoalMineId());
//        record.setTransportCompanyId(recordDetails.getTransportCompanyId());
//        record.setQuantity(recordDetails.getQuantity());
//        record.setTransportDate(recordDetails.getTransportDate());
//        record.setVehicleNumber(recordDetails.getVehicleNumber());
//        record.setDriverName(recordDetails.getDriverName());
//        record.setTransportFee(recordDetails.getTransportFee());
//
//        TransportRecord updatedRecord = transportRecordService.saveTransportRecord(record);
//        return ResponseEntity.ok(updatedRecord);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteRecord(@PathVariable Long id) {
//        transportRecordService.deleteRecord(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/date-range")
//    public List<TransportRecord> getRecordsByDateRange(
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
//        return transportRecordService.getRecordsByDateRange(startDate, endDate);
//    }
//
//    @GetMapping("/coal-mine/{coalMineId}")
//    public List<TransportRecord> getRecordsByCoalMine(@PathVariable Long coalMineId) {
//        return transportRecordService.getRecordsByCoalMine(coalMineId);
//    }
//
//    @GetMapping("/transport-company/{transportCompanyId}")
//    public List<TransportRecord> getRecordsByTransportCompany(@PathVariable Long transportCompanyId) {
//        return transportRecordService.getRecordsByTransportCompany(transportCompanyId);
//    }
}    