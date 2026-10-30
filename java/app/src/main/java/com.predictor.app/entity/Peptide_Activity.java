package com.predictor.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "peptide_activities")
public class Peptide_Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peptide_id")
    private Peptide peptide;


    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;


    @Column(name = "activity_class")
    private String activityClass;

    public Peptide_Activity() {
    }


    public String getActivityClass() {

        return activityClass;
    }

    public void setActivityClass(String activityClass) {

        this.activityClass = activityClass;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public Peptide getPeptide() {

        return peptide;
    }

    public Disease getDisease() {

        return disease;
    }

    public void setPeptide(Peptide p) {

        this.peptide = p;
    }

    public void setDisease(Disease d) {

        this.disease = d;
    }


}