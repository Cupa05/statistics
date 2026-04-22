package com.example.statistics.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.statistics.dto.GovernmentBondDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "government_bond")
public class GovernmentBond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Ezt az Id-t a interestpayment governmentbondID-val

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double interestRate;

    private Double depositCapitalRate;

    @OneToMany(mappedBy = "governmentBond", cascade = CascadeType.ALL)
    private List<InterestPayment> interestPaymentList = new ArrayList<>();

    public GovernmentBond(GovernmentBondDto dto) {

        this.name = dto.getName();
        this.description = dto.getDescription();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.interestRate = dto.getInterestRate();
        this.depositCapitalRate = dto.getDepositCapitalRate();
    }
}
