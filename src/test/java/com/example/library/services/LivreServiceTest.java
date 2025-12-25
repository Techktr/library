package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;
import com.example.library.repository.LivreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LivreServiceTest {

    private LivreService livreService;
    private LivreDTO livreDTO;
    private LivreRepository livreRepository;

    @BeforeEach
    public void setUp() {
        livreRepository = mock(LivreRepository.class);
        livreService = new LivreService(livreRepository);
        livreDTO = new LivreDTO("Clean Code", "Robert Martin");

        when(livreRepository.save(any(Livre.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    public void shouldCreateBook() {

        Livre result = livreService.createBook(livreDTO);

        assertNotNull(result);
    }

    @Test
    public void shouldGeneratedUniqueID(){

        Livre result = livreService.createBook(new LivreDTO("Clean Code", "Robert Martin"));

        assertNotNull(result.getUuid());
    }

    @Test
    void shouldGenerateDifferentUUIDsForDifferentBooks() {
        Livre livre1 = livreService.createBook(livreDTO);
        Livre livre2 = livreService.createBook(livreDTO);

        assertNotEquals(livre1.getUuid(), livre2.getUuid());
    }

    @Test
    void shouldSaveBookToRepository() {
        LivreRepository livreRepository = mock(LivreRepository.class);
        LivreService livreService = new LivreService(livreRepository);

        Livre livre = livreService.saveBook(livreDTO);

        verify(livreRepository).save(any(Livre.class));
    }
}
