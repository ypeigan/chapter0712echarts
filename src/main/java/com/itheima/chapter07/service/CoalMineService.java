package com.itheima.chapter07.service;

import com.itheima.chapter07.entity.CoalMine;
import com.itheima.chapter07.repository.CoalMineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoalMineService {
    @Autowired
    private CoalMineRepository coalMineRepository;
//
//    public CoalMine saveCoalMine(CoalMine coalMine) {
//        return coalMineRepository.save(coalMine);
//    }

    public List<CoalMine> getAllCoalMines() {
        return coalMineRepository.findAll();
    }

//    public Optional<CoalMine> getCoalMineById(Long id) {
//        return coalMineRepository.findById(id);
//    }
//
//    public void deleteCoalMine(Long id) {
//        coalMineRepository.deleteById(id);
//    }
//
//    public List<CoalMine> getCoalMinesByLocation(String location) {
//        return coalMineRepository.findByLocation(location);
//    }
}    