package com.itheima.chapter07.controller;



import com.itheima.chapter07.entity.CoalType;
import com.itheima.chapter07.service.CoalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CoalTypeController {

    @Autowired
    private CoalTypeService coalTypeService;

    @GetMapping("/coaltypes")
    public List<CoalType> getAllCoalTypes() {
        List<CoalType> coalTypes = coalTypeService.getAllCoalTypes();
        return coalTypeService.getAllCoalTypes();
    }

    @GetMapping("/coaltypes/price-chart")
    public Map<String, Object> getCoalPriceChartData() {
        List<CoalType> coalTypes = coalTypeService.getAllCoalTypes();

        // 按煤类型分组
        Map<String, List<CoalType>> typeMap = new HashMap<>();
        for (CoalType coal : coalTypes) {
            typeMap.computeIfAbsent(coal.getCoalType(), k -> new ArrayList<>()).add(coal);
        }

        // 准备图表数据
        List<String> categories = new ArrayList<>();
        List<BigDecimal> prices = new ArrayList<>(); // 改为 BigDecimal 类型
        List<String> colors = new ArrayList<>();

        // 颜色映射
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("动力煤", "#3B82F6");
        colorMap.put("炼焦煤", "#10B981");
        colorMap.put("无烟煤", "#8B5CF6");
        colorMap.put("褐煤", "#F59E0B");
        colorMap.put("喷吹煤", "#EC4899");

        // 按价格排序（降序）
        coalTypes.sort(Comparator.comparing(CoalType::getPrice).reversed());

        // 填充图表数据
        for (CoalType coal : coalTypes) {
            categories.add(coal.getCoalName());
            prices.add(coal.getPrice()); // 直接添加 BigDecimal
            colors.add(colorMap.getOrDefault(coal.getCoalType(), "#3B82F6"));
        }

        // 计算统计数据（使用 BigDecimal 进行精确计算）
        BigDecimal totalPrice = prices.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgPrice = totalPrice.divide(
                BigDecimal.valueOf(prices.size()),
                2, // 保留两位小数
                BigDecimal.ROUND_HALF_UP // 四舍五入
        );

        BigDecimal maxPrice = prices.stream()
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);

        BigDecimal minPrice = prices.stream()
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);

        Map<String, Object> result = new HashMap<>();
        result.put("categories", categories);
        result.put("prices", prices); // 返回 BigDecimal 列表
        result.put("colors", colors);
        result.put("statistics", Map.of(
                "avgPrice", avgPrice,
                "maxPrice", maxPrice,
                "minPrice", minPrice,
                "typeCount", typeMap.size(),
                "totalCount", coalTypes.size()
        ));

        return result;
    }



    // 根据ID获取煤矿品种
//    @GetMapping("/{id}")
//    public ResponseEntity<CoalType> getCoalTypeById(@PathVariable Integer id) {
//        Optional<CoalType> coalType = coalTypeService.getCoalTypeById(id);
//        return coalType.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    // 根据煤类型获取煤矿品种
//    @GetMapping("/type/{coalType}")
//    public ResponseEntity<List<CoalType>> getCoalTypesByType(@PathVariable String coalType) {
//        List<CoalType> coalTypes = coalTypeService.getCoalTypesByType(coalType);
//        return new ResponseEntity<>(coalTypes, HttpStatus.OK);
//    }
//
//    // 根据发热量范围获取煤矿品种
//    @GetMapping("/calorific-value")
//    public ResponseEntity<List<CoalType>> getCoalTypesByCalorificValue(
//            @RequestParam("min") int min, @RequestParam("max") int max) {
//        List<CoalType> coalTypes = coalTypeService.getCoalTypesByCalorificValue(min, max);
//        return new ResponseEntity<>(coalTypes, HttpStatus.OK);
//    }
//
//    // 根据价格范围获取煤矿品种
//    @GetMapping("/price")
//    public ResponseEntity<List<CoalType>> getCoalTypesByPrice(
//            @RequestParam("min") double min, @RequestParam("max") double max) {
//        List<CoalType> coalTypes = coalTypeService.getCoalTypesByPrice(min, max);
//        return new ResponseEntity<>(coalTypes, HttpStatus.OK);
//    }
//
//    // 添加新的煤矿品种
//    @PostMapping
//    public ResponseEntity<CoalType> addCoalType(@RequestBody CoalType coalType) {
//        CoalType savedCoalType = coalTypeService.saveCoalType(coalType);
//        return new ResponseEntity<>(savedCoalType, HttpStatus.CREATED);
//    }
//
//    // 更新煤矿品种信息
//    @PutMapping("/{id}")
//    public ResponseEntity<CoalType> updateCoalType(@PathVariable Integer id, @RequestBody CoalType coalType) {
//        Optional<CoalType> existingCoalType = coalTypeService.getCoalTypeById(id);
//        if (existingCoalType.isPresent()) {
//            coalType.setId(id);
//            CoalType updatedCoalType = coalTypeService.saveCoalType(coalType);
//            return new ResponseEntity<>(updatedCoalType, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // 删除煤矿品种
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCoalType(@PathVariable Integer id) {
//        Optional<CoalType> coalType = coalTypeService.getCoalTypeById(id);
//        if (coalType.isPresent()) {
//            coalTypeService.deleteCoalType(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
