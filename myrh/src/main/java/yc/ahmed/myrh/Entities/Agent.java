package yc.ahmed.myrh.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Data
@Entity
public class Agent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "log")
    private String log;
    @Basic
    @Column(name = "pass")
    private String pass;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return id == agent.id && Objects.equals(log, agent.log) && Objects.equals(pass, agent.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, log, pass);
    }
}
