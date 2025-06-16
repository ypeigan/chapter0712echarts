package com.itheima.chapter07.controller;


import com.itheima.chapter07.service.TransportCompanyService;
import com.itheima.chapter07.entity.TransportCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TransportCompanyController {
    @Autowired
    private TransportCompanyService transportCompanyService;

    @GetMapping("/transportcompanies")
    public List<TransportCompany> getAllCompanies() {

        List<TransportCompany> transportCompanies = transportCompanyService.getAllCompanies();
        return transportCompanyService.getAllCompanies();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TransportCompany> getCompanyById(@PathVariable Long id) {
//        Optional<TransportCompany> companyOptional = transportCompanyService.getCompanyById(id);
//        return companyOptional.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public TransportCompany createCompany(@RequestBody TransportCompany company) {
//        return transportCompanyService.saveTransportCompany(company);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TransportCompany> updateCompany(@PathVariable Long id, @RequestBody TransportCompany companyDetails) {
//        Optional<TransportCompany> companyOptional = transportCompanyService.getCompanyById(id);
//        if (!companyOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        TransportCompany company = companyOptional.get();
//        company.setCompanyName(companyDetails.getCompanyName());
//        company.setLocation(companyDetails.getLocation());
//        company.setContactPerson(companyDetails.getContactPerson());
//        company.setPhone(companyDetails.getPhone());
//        company.setVehicleCount(companyDetails.getVehicleCount());
//
//        TransportCompany updatedCompany = transportCompanyService.saveTransportCompany(company);
//        return ResponseEntity.ok(updatedCompany);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
//        transportCompanyService.deleteCompany(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/location/{location}")
//    public List<TransportCompany> getCompaniesByLocation(@PathVariable String location) {
//        return transportCompanyService.getCompaniesByLocation(location);
//    }
}    