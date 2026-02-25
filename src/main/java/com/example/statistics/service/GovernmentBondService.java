package com.example.statistics.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.statistics.dto.GovernmentBondDto;
import com.example.statistics.entity.GovernmentBond;
import com.example.statistics.repository.GovernmentBondRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GovernmentBondService {

    private final GovernmentBondRepository governmentBondRepository;

    public GovernmentBond saveGovernmentBond(GovernmentBond governmentBond) {
        return governmentBondRepository.save(governmentBond);
    }

    public GovernmentBond saveGovernmentBond(GovernmentBondDto governmentBondDto) {
        GovernmentBond governmentBond = convertToEntity(governmentBondDto);
        return governmentBondRepository.save(governmentBond);
    }

    private GovernmentBond convertToEntity(GovernmentBondDto dto) {
        return new GovernmentBond(dto);
    }

    public List<GovernmentBond> getAllGovernmentBond() {
        return governmentBondRepository.findAll();
    }

    public GovernmentBond getGovernmentBondById(Long id) {
        return governmentBondRepository.getGovernmentBondById(id);
    }

    public List<GovernmentBond> getGovernmentBondsBetweenStartDates(OffsetDateTime startDate, OffsetDateTime endDate) {
        return governmentBondRepository.findByStartDateBetween(startDate, endDate);
    }
}
