package com.example.statistics.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String Name;
    private LocalDate birthDate;
}
