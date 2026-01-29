package com.example.statistics.controller;

import java.time.OffsetDateTime;
import java.util.List;

import com.example.statistics.dto.GovernmentBondDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.statistics.entity.GovernmentBond;
import com.example.statistics.service.GovernmentBondService;

@RestController
@RequestMapping("portfolio/governmentBond")
public class GovernmentBondController {
    @Autowired
    private final GovernmentBondService governmentBondService;

    public GovernmentBondController(GovernmentBondService governmentBondService) {
        this.governmentBondService = governmentBondService;
    }
    @GetMapping("/list")
    public ResponseEntity<List<GovernmentBond>> getAllGovernmentBond() {
        return ResponseEntity.ok(governmentBondService.getAllGovernmentBond());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GovernmentBond> getGovernmentBondById(@PathVariable Long id) {
        return ResponseEntity.ok(governmentBondService.getGovernmentBondById(id));
    }

    @GetMapping("/list/betweenStartDates")
    public ResponseEntity<List<GovernmentBond>> getGovernmentBondsBetweenStartDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endDate) {
        return ResponseEntity.ok(governmentBondService.getGovernmentBondsBetweenStartDates(startDate, endDate));
    }

    @PostMapping("/save")
    public ResponseEntity<GovernmentBond> saveGovernmentBond(@RequestBody GovernmentBondDto governmentBond) {
        GovernmentBond savedBond = governmentBondService.saveGovernmentBond(governmentBond);
        return ResponseEntity.ok(savedBond);
    }
}

