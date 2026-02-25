package com.example.statistics.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.statistics.entity.GovernmentBond;

@Repository
public interface GovernmentBondRepository extends JpaRepository<GovernmentBond, Long> {

    @Query("SELECT gb FROM GovernmentBond gb WHERE gb.id = :id")
    GovernmentBond getGovernmentBondById(@Param("id") Long id);

    List<GovernmentBond> findByStartDateBetween(OffsetDateTime startDate, OffsetDateTime endDate);
}
