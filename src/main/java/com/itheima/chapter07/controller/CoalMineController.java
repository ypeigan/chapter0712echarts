package com.itheima.chapter07.controller;

import com.itheima.chapter07.entity.CoalMine;
import com.itheima.chapter07.service.CoalMineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8080")
public class CoalMineController {
    @Autowired
    private CoalMineService coalMineService;

    @GetMapping("/coalmines")
    public List<CoalMine> getAllCoalMines() {
        List<CoalMine> coalMines = coalMineService.getAllCoalMines();
        return coalMineService.getAllCoalMines();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CoalMine> getCoalMineById(@PathVariable Long id) {
//        Optional<CoalMine> coalMineOptional = coalMineService.getCoalMineById(id);
//        return coalMineOptional.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public CoalMine createCoalMine(@RequestBody CoalMine coalMine) {
//        return coalMineService.saveCoalMine(coalMine);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CoalMine> updateCoalMine(@PathVariable Long id, @RequestBody CoalMine coalMineDetails) {
//        Optional<CoalMine> coalMineOptional = coalMineService.getCoalMineById(id);
//        if (!coalMineOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        CoalMine coalMine = coalMineOptional.get();
//        coalMine.setMineName(coalMineDetails.getMineName());
//        coalMine.setLocation(coalMineDetails.getLocation());
//        coalMine.setCoalReserves(coalMineDetails.getCoalReserves());
//        coalMine.setContactPerson(coalMineDetails.getContactPerson());
//        coalMine.setPhone(coalMineDetails.getPhone());
//
//        CoalMine updatedCoalMine = coalMineService.saveCoalMine(coalMine);
//        return ResponseEntity.ok(updatedCoalMine);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCoalMine(@PathVariable Long id) {
//        coalMineService.deleteCoalMine(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/location/{location}")
//    public List<CoalMine> getCoalMinesByLocation(@PathVariable String location) {
//        return coalMineService.getCoalMinesByLocation(location);
//    }
}    