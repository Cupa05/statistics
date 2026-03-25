package com.example.statistics.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InterestPaymentDto {
    private Long governmentBondId;
    private LocalDate startDate;
    private LocalDate turnDate;
    private Integer daysSincePreviousRound;
}
