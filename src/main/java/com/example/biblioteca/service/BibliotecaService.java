package com.example.biblioteca.service;

import com.example.biblioteca.model.Biblioteca;
import com.example.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BibliotecaService {

    @Autowired
    private LivrosRepository livrosRepository;


    public Biblioteca salvarLivro(Biblioteca biblioteca) {
        return livrosRepository.save(biblioteca);

    }

    public Biblioteca buscarLivro(UUID id){

        Optional<Biblioteca> biblioteca = livrosRepository.findById(id);

        return biblioteca.orElse(null);
    }

    public void deletarLivro(UUID uuid){

         livrosRepository.deleteById(uuid);

    }


}
