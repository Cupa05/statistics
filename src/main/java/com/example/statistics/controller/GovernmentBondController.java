package com.example.statistics.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.statistics.dto.GovernmentBondDto;
import com.example.statistics.entity.GovernmentBond;
import com.example.statistics.service.GovernmentBondService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("portfolio/governmentBond")
@RequiredArgsConstructor
public class GovernmentBondController {

    private final GovernmentBondService governmentBondService;

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
