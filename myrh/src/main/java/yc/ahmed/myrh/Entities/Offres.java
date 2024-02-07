package yc.ahmed.myrh.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import yc.ahmed.myrh.Enums.OffresStatus;

import java.util.Objects;
@Data
@Entity
public class Offres {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "profil")
    private String profil;

    @Basic
    @Column(name = "study")
    private String study;
    @Basic
    @Column(name = "salaire")
    private String salaire;
    @Basic
    @Column(name = "ville")
    private String ville;

    @ManyToOne
    @JoinColumn(name = "society_id")
    @JsonManagedReference
    private Society society;

    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OffresStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offres offres = (Offres) o;
        return id == offres.id && Objects.equals(profil, offres.profil) && Objects.equals(study, offres.study) && Objects.equals(salaire, offres.salaire) && Objects.equals(ville, offres.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profil, study, salaire, ville);
    }
}
