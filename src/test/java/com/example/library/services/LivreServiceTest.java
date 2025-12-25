package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LivreServiceTest {

    @Test
    public void shouldCreateBook() {
        LivreDTO livreDTO = new LivreDTO("Clean Code", "Robert Martin");
        LivreService livreService = new LivreService();

        Livre result = livreService.createBook(livreDTO);

        assertNotNull(result);
    }
}
