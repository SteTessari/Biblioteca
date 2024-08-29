package com.example.biblioteca.model;

import com.example.biblioteca.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Biblioteca implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID sera gerado automaticamente pelo banco de dados
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "autor")
    private String autor;

    @Column(name = "quantidade")
    private int quantidade;

}
