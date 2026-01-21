package com.example.statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.statistics.entity.GovernmentBond;

@Repository
interface GovernmentBondRepository extends JpaRepository<GovernmentBond, Long> {
    // TODO-Következő task PF-13
    // @Query("SELECT gb FROM GovernmentBond gb WHERE gb.id = :id")
    // GovernmentBond getGovernmentBondById(Long id);
}
