package com.example.statistics.service;

import java.time.OffsetDateTime;
import java.util.List;

import com.example.statistics.dto.GovernmentBondDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.statistics.entity.GovernmentBond;
import com.example.statistics.repository.GovernmentBondRepository;

@Service
public class GovernmentBondService {

    @Autowired
    private final GovernmentBondRepository governmentBondRepository;

    public GovernmentBondService(GovernmentBondRepository governmentBondRepository) {
        this.governmentBondRepository = governmentBondRepository;
    }

    public GovernmentBond saveGovernmentBond(GovernmentBond governmentBond) {
        return governmentBondRepository.save(governmentBond);
    }

    public GovernmentBond saveGovernmentBond(GovernmentBondDto governmentBondDto) {
        GovernmentBond governmentBond = convertToEntity(governmentBondDto);
        return governmentBondRepository.save(governmentBond);
    }

    private GovernmentBond convertToEntity(GovernmentBondDto dto) {
        GovernmentBond governmentBond = new GovernmentBond();
        governmentBond.setName(dto.getName());
        governmentBond.setDescription(dto.getDescription());
        governmentBond.setStartDate(dto.getStartDate());
        governmentBond.setEndDate(dto.getEndDate());
        governmentBond.setInterestRate(dto.getInterestRate() != null ? dto.getInterestRate().doubleValue() : null);
        governmentBond.setDepositCapitalRate(dto.getDepositCapitalRate() != null ? dto.getDepositCapitalRate().doubleValue() : null);
        return governmentBond;
    }

    public List<GovernmentBond> getAllGovernmentBond() {
        return governmentBondRepository.findAll();
    }

    public GovernmentBond getGovernmentBondById(Long id) {
        GovernmentBond bond = governmentBondRepository.getGovernmentBondById(id);
        return bond;
    }

    public List<GovernmentBond> getGovernmentBondsBetweenStartDates(OffsetDateTime startDate, OffsetDateTime endDate) {
        return governmentBondRepository.findByStartDateBetween(startDate, endDate);
    }
}
