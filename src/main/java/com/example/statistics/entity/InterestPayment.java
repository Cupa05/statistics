package com.example.statistics.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.example.statistics.dto.InterestPaymentDto;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "interest_payment")
public class InterestPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate turnDate;

    private Integer daysSincePreviousRound;

    @ManyToOne
    @JoinColumn(name = "government_bond_id")
    private GovernmentBond governmentBond;

    public InterestPayment(InterestPaymentDto dto) {
        this.startDate = dto.getStartDate();
        this.turnDate = dto.getTurnDate();
        this.daysSincePreviousRound = dto.getDaysSincePreviousRound();
    }
}
