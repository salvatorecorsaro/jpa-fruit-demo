package com.example.jpafruitdemo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.jpafruitdemo.dao.Kombucha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KombuchaRepository extends JpaRepository<Kombucha, String> {

// find all kombucha ordered by price
    List<Kombucha> findAllByOrderByPriceDesc();


}
