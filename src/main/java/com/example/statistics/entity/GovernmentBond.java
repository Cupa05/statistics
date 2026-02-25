package com.example.statistics.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.example.statistics.dto.GovernmentBondDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GovernmentBond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private Double interestRate;

    private Double depositCapitalRate;

    public GovernmentBond(GovernmentBondDto dto) {

        this.name = dto.getName();
        this.description = dto.getDescription();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.interestRate = dto.getInterestRate() != null ? dto.getInterestRate().doubleValue() : null;
        this.depositCapitalRate = dto.getDepositCapitalRate() != null
                ? dto.getDepositCapitalRate().doubleValue()
                : null;
    }
}
