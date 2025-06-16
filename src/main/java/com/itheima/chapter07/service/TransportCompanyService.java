package com.itheima.chapter07.service;


import com.itheima.chapter07.entity.TransportCompany;
import com.itheima.chapter07.repository.TransportCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportCompanyService {
    @Autowired
    private TransportCompanyRepository transportCompanyRepository;

//    public TransportCompany saveTransportCompany(TransportCompany company) {
//        return transportCompanyRepository.save(company);
//    }

    public List<TransportCompany> getAllCompanies() {
        return transportCompanyRepository.findAll();
    }

//    public Optional<TransportCompany> getCompanyById(Long id) {
//        return transportCompanyRepository.findById(id);
//    }
//
//    public void deleteCompany(Long id) {
//        transportCompanyRepository.deleteById(id);
//    }
//
//    public List<TransportCompany> getCompaniesByLocation(String location) {
//        return transportCompanyRepository.findByLocation(location);
//    }
}    