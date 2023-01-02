package com.example.biblioteca.serviceTest;

import com.example.biblioteca.model.Biblioteca;
import com.example.biblioteca.repository.LivrosRepository;
import com.example.biblioteca.service.BibliotecaService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("TESTE_UNITARIO")
@ExtendWith(MockitoExtension.class)
public class BibliotecaServiceTest {

    @InjectMocks
    private BibliotecaService bibliotecaService;

    @Mock
    private LivrosRepository livrosRepository;

    @Test
    void salvarBibliotecaTest() {
        UUID id = UUID.randomUUID();
        Biblioteca biblioteca = Biblioteca.builder().id(id).build();

        livrosRepository.save(Mockito.any());
        bibliotecaService.salvarLivro(biblioteca);
    }

    @Test
    void buscarBibliotecaTest() {
        UUID uuid = UUID.randomUUID();
        Biblioteca biblioteca = Biblioteca.builder().id(uuid).build();


//        Mockito.when(livrosRepository.save(Mockito.any())).thenReturn(Optional.of(biblioteca));
        Biblioteca biblioteca1 = bibliotecaService.buscarLivro(uuid);
        Mockito.verify(livrosRepository, Mockito.times(1)).findById(uuid);
        assertEquals(uuid, biblioteca1.getId());
    }

}
