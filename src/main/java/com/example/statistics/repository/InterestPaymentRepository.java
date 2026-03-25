package com.example.statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.statistics.entity.InterestPayment;

@Repository
public interface InterestPaymentRepository extends JpaRepository<InterestPayment, Long> {

}
