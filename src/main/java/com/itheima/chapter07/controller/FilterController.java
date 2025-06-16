package com.itheima.chapter07.controller;

import com.itheima.chapter07.entity.CoalType;
import com.itheima.chapter07.service.CoalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FilterController {
    @Autowired
    private CoalTypeService coalTypeService;

    @GetMapping("/coaltypes/filter")
    public List<CoalType> filterCoalTypes(
            @RequestParam(name = "coalType", defaultValue = "DEFAULT_TYPE") List<String> types
    ) {
        // 特殊处理默认值
        if (types.size() == 1 && "DEFAULT_TYPE".equals(types.get(0))) {
            return Collections.emptyList(); // 或返回特定默认值
        }
        return coalTypeService.getCoalTypesByTypes(types);
    }

    // 获取各类煤的统计数据
    @GetMapping("/coaltypes/statistics")
    public Map<String, Object> getCoalStatistics() {
        List<CoalType> coalTypes = coalTypeService.getAllCoalTypes();

        // 计算统计数据
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal maxPrice = BigDecimal.ZERO;
        BigDecimal minPrice = BigDecimal.ZERO;

        Map<String, Integer> typeCounts = new HashMap<>();

        if (!coalTypes.isEmpty()) {
            // 初始化最大最小值
            maxPrice = coalTypes.get(0).getPrice();
            minPrice = coalTypes.get(0).getPrice();

            for (CoalType coal : coalTypes) {
                BigDecimal price = coal.getPrice();
                totalPrice = totalPrice.add(price);
                maxPrice = maxPrice.max(price);
                minPrice = minPrice.min(price);

                typeCounts.put(coal.getCoalType(), typeCounts.getOrDefault(coal.getCoalType(), 0) + 1);
            }
        }

        // 计算平均值（保留两位小数）
        BigDecimal avgPrice = totalPrice.divide(
                BigDecimal.valueOf(coalTypes.size()),
                2,
                BigDecimal.ROUND_HALF_UP
        );

        Map<String, Object> result = new HashMap<>();
        result.put("avgPrice", avgPrice);
        result.put("maxPrice", maxPrice);
        result.put("minPrice", minPrice);
        result.put("totalCount", coalTypes.size());
        result.put("typeCounts", typeCounts);

        return result;
    }
}
