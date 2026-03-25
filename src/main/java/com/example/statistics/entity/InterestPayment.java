package com.example.statistics.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.example.statistics.dto.InterestPaymentDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InterestPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long governmentBondId;
    private LocalDate startDate;
    private LocalDate turnDate;
    private Integer daysSincePreviousRound;

    public InterestPayment(InterestPaymentDto dto) {
        this.governmentBondId = dto.getGovernmentBondId();
        this.startDate = dto.getStartDate();
        this.turnDate = dto.getTurnDate();
        this.daysSincePreviousRound = dto.getDaysSincePreviousRound();
    }
}
