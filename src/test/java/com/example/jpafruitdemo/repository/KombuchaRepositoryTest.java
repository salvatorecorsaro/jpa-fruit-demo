package com.example.jpafruitdemo.repository;

import com.example.jpafruitdemo.dao.Kombucha;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KombuchaRepositoryTest {

    @Autowired
    KombuchaRepository kombuchaRepository;

    @BeforeEach
    void setUp() {
        var kombucha_orange = new Kombucha("k-orange", BigDecimal.valueOf(9.99));
        var kombucha_apple = new Kombucha("k-apple", BigDecimal.valueOf(8.99));
        kombuchaRepository.save(kombucha_orange);
        kombuchaRepository.save(kombucha_apple);
    }

    @AfterEach
    void tearDown() {
        kombuchaRepository.deleteAll();
    }

    @Test
    public void test_k_list(){
        var k_list = kombuchaRepository.findAll();

        assertEquals(2, k_list.size());
    }





    // test findAllByOrderByPriceDesc() is ordering by price;
    @Test
    public void test_findAllByOrderByPriceDesc(){
        var k_list = kombuchaRepository.findAllByOrderByPriceDesc();
        assertEquals(2, k_list.size());
        assertEquals("k-orange", k_list.get(0).getName());
        assertEquals("k-apple", k_list.get(1).getName());
    }

    // clear the kombucha repository and test if kombuchaRepository can save and delete kombucha
    @Test
    public void test_save_and_delete_kombucha() {
        var kombucha_orange = new Kombucha("k-orange", BigDecimal.valueOf(9.99));
        var kombucha_apple = new Kombucha("k-apple", BigDecimal.valueOf(8.99));
        kombuchaRepository.save(kombucha_orange);
        kombuchaRepository.save(kombucha_apple);
        kombuchaRepository.delete(kombucha_apple);
        var k_list = kombuchaRepository.findAll();
        assertEquals(1, k_list.size());
    }

}