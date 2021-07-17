package com.example.jpafruitdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Kombucha {


    @Id
    private String id;

    private String name;


    private BigDecimal price;

    public Kombucha() {
        this.id = name + "_id";
    }

    public Kombucha(String id, String name, BigDecimal price) {
        this.id = name + "_id";
        this.name = name;
        this.price = price;
    }

    public Kombucha(String name, BigDecimal price) {
        this.id = name + "_id";
        this.name = name;
        this.price = price;
    }
}
