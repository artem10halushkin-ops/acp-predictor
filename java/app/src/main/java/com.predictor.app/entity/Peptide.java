package com.predictor.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "peptides")
public class Peptide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String sequence;


    public Peptide() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public String getSequence() {

        return sequence;
    }

    public void setSequence(String str) {

        this.sequence = str;
    }

}