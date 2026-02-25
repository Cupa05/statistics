package com.example.statistics.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GovernmentBondDto {
    private String name;
    private String description;
    private OffsetDateTime StartDate;
    private OffsetDateTime endDate;
    private Float interestRate;
    private Float depositCapitalRate;

}
