package com.example.jpafruitdemo.repository;

import com.example.jpafruitdemo.dao.Fruit;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FruitRepositoryTest {


    @Autowired
    FruitRepository fruitRepository;

    @BeforeEach
    void setUp() {
        var durian = new Fruit(null, "Durian");
        fruitRepository.save(durian);
    }

    @AfterEach
    void tearDown() {
        fruitRepository.deleteAll();
    }

    @Test
    public void createAFruit_positiveCreation(){
        var fruits = fruitRepository.findAll();
        assertEquals(1, fruits.size());
    }

    @Test
    public void createAFruit_positiveCreationTwo(){
        var banana = new Fruit(null, "Banana");
        fruitRepository.save(banana);
        var fruits = fruitRepository.findAll();
        assertEquals(2, fruits.size());
    }

    @Test
    public void findFruitByName_Found(){
        var fruit = fruitRepository.getFruitsByName("Durian");
        assertTrue(fruit.isPresent());
    }

    @Test
    public void findFruitByName_NotFound(){
        var fruit = fruitRepository.getFruitsByName("Banana");
        assertTrue(fruit.isEmpty());
    }

    @Test
    public void findFruitByName_BananaFound(){
        var banana = new Fruit(null, "Banana");
        fruitRepository.save(banana);
        var fruit = fruitRepository.getFruitsByName("Banana");
        assertTrue(fruit.isPresent());
    }

}