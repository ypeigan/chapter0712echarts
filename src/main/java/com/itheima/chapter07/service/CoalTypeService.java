package com.itheima.chapter07.service;

import java.util.Optional;
import com.itheima.chapter07.entity.CoalType;
import com.itheima.chapter07.repository.CoalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoalTypeService {
    @Autowired
    private CoalTypeRepository coalTypeRepository;

    public List<CoalType> getAllCoalTypes(){
        return coalTypeRepository.findAll();
    }

    public List<CoalType> getCoalTypesByTypes(List<String> types) {
        return coalTypeRepository.findByCoalTypeIn(types);
    }

    public Optional<CoalType> getCoalTypeById(Integer id) {
        return coalTypeRepository.findById(id);
    }

    public List<CoalType> getCoalTypesByCalorificValue(int min, int max) {
        return coalTypeRepository.findByCalorificValueBetween(min, max);
    }


    public List<CoalType> getCoalTypesByPrice(double min, double max) {
        return coalTypeRepository.findByPriceBetween(min, max);
    }


    public CoalType saveCoalType(CoalType coalType) {
        return coalTypeRepository.save(coalType);
    }


    public void deleteCoalType(Integer id) {
        coalTypeRepository.deleteById(id);
    }

}
