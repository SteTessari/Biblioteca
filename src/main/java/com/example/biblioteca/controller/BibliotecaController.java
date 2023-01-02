package com.example.biblioteca.controller;


import com.example.biblioteca.model.Biblioteca;
import com.example.biblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("biblioteca")
public class BibliotecaController {
/*ResponseEntity é um endPoint para acessar os usuarios
retorna respostas de requisições web */
    @Autowired
    private BibliotecaService bibliotecaService;


    //Para inserir informacao
    @PostMapping
    public ResponseEntity<Object> inserirLivro(@RequestBody Biblioteca bibliotecaDTO) {

        bibliotecaDTO = bibliotecaService.salvarLivro(bibliotecaDTO);
        return ResponseEntity.ok().body(bibliotecaDTO);
    }

    //Para buscar informacao
    @GetMapping("{id}")
    public ResponseEntity<Object> buscarLivro(@PathVariable UUID id) {
        Biblioteca biblioteca = bibliotecaService.buscarLivro(id);

        return ResponseEntity.ok().body(biblioteca);
    }

    //Para atualizar informacao
    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarLivro(@RequestBody Biblioteca biblioteca) {
        if (biblioteca.getId() == null) {
            throw new RuntimeException();
        }
        Biblioteca bibliotecaAtualizarNoBanco = bibliotecaService.salvarLivro(biblioteca);
        return ResponseEntity.ok().body(bibliotecaAtualizarNoBanco);
    }

    //Para deletar informacao
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarLivro(@PathVariable UUID id) {
        bibliotecaService.deletarLivro(id);
        return ResponseEntity.ok().body("Removido com sucesso!");
    }
}
