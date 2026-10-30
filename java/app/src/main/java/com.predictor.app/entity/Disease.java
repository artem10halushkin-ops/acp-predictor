package com.predictor.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diseases")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;

    public Disease() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String str) {

        this.name = str;
    }

}