package com.kleiman.votingspring.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pauta")
public class Pauta {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private long id;
    @Column(name = "titulo")
    @Getter @Setter
    private String titulo;
    @Column(name = "descricao")
    @Getter @Setter
    private String descricao;
    @Column(name = "aberto")
    @Getter @Setter
    private boolean aberto;

    @Override
    public String toString() {
        return "Pauta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", aberto=" + aberto +
                '}';
    }
}
