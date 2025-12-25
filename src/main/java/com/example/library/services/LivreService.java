package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;
import com.example.library.repository.LivreRepository;

public class LivreService {

    private LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public Livre createBook(LivreDTO livreDTO) {
        return new Livre(livreDTO.getNom(), livreDTO.getAuteur());
    }

    public Livre saveBook(LivreDTO livreDTO) {
        Livre livre = new Livre(livreDTO.getNom(), livreDTO.getAuteur());
        return livreRepository.save(livre);
    }
}
