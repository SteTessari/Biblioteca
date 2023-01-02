package com.example.biblioteca.repository;

import com.example.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface LivrosRepository extends JpaRepository<Biblioteca, UUID> {

}
