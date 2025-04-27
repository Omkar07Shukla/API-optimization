package com.example.optimizationapi.controller;

import com.example.optimizationapi.model.MovePlanRequest;
import com.example.optimizationapi.model.MovePlanResponse;
import com.example.optimizationapi.service.OptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/optimize")
public class OptimizationController {

    @Autowired
    private OptimizationService optimizationService;

    @PostMapping
    public MovePlanResponse optimizeMovePlan(@RequestBody MovePlanRequest request) {
        long startTime = System.nanoTime();
        MovePlanResponse response = optimizationService.optimize(request);
        long endTime = System.nanoTime();
        response.setLatencyMs((endTime - startTime) / 1_000_000.0);
        return response;
    }
}
