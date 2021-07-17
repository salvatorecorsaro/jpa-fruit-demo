package com.example.jpafruitdemo.repository;

import com.example.jpafruitdemo.dao.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Optional<Fruit> getFruitsByName(String name);
}
