package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;

public class LivreService {

    public Livre createBook(LivreDTO livreDTO) {
        return new Livre(livreDTO.getNom(), livreDTO.getAuteur());
    }
}
