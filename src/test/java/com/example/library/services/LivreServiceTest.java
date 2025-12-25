package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LivreServiceTest {

    private LivreService livreService;
    private LivreDTO livreDTO;

    @BeforeEach
    public void setUp() {
        livreService = new LivreService();
        livreDTO = new LivreDTO("Clean Code", "Robert Martin");
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
}
