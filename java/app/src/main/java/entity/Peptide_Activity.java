package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "peptide_activities")
class Peptide_Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "peptide_id")
    private Peptide peptide;


    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    public Peptide_Activity() {
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