package yc.ahmed.myrh.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@Entity

public class Society {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "adresse")
    private String adresse;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "num")
    private Long num;
    @Basic
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "society",cascade = {CascadeType.MERGE} , fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Offres> offres = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Society society = (Society) o;
        return id == society.id && Objects.equals(login, society.login) && Objects.equals(password, society.password) && Objects.equals(adresse, society.adresse) && Objects.equals(email, society.email) && Objects.equals(num, society.num) && Objects.equals(image, society.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, adresse, email, num, image);
    }
}
