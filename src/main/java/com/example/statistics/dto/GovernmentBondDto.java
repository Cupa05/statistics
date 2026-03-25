package com.example.statistics.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GovernmentBondDto {
    private String name;
    private String description;
    private LocalDate StartDate;
    private LocalDate endDate;
    private Float interestRate;
    private Float depositCapitalRate;

}
