package com.example.statistics.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

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

