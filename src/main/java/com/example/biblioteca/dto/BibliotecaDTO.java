package com.example.biblioteca.dto;

import com.example.biblioteca.enums.Categoria;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BibliotecaDTO {

    private UUID id;
    private String nome;
    private Categoria categoria;
    private String autor;
    private int quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BibliotecaDTO)) return false;
        BibliotecaDTO that = (BibliotecaDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
