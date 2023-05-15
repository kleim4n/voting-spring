package com.kleiman.votingspring.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "voto")
public class Voto {
    /*
    id INT PRIMARY KEY,
   id_pauta INT NOT NULL,
   id_associado INT NOT NULL,
   voto BOOLEAN NOT NULL
     */
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private long id;
    @Column(name = "idPauta")
    @NotNull
    @Getter
    @Setter
    private long idPauta;
    @Column(name = "idAssociado")
    @NotNull
    @Getter
    @Setter
    private long idAssociado;
    @Column(name = "voto")
    @NotNull
    @Getter
    @Setter
    private boolean voto;

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", idPauta=" + idPauta +
                ", idAssociado=" + idAssociado +
                ", voto=" + voto +
                '}';
    }
}
