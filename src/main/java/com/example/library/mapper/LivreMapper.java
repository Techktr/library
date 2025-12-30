package com.example.library.mapper;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;


public class LivreMapper {

    public LivreMapper() {}

    public LivreDTO map(Livre livre) {
        return new LivreDTO(livre.getNom(), livre.getAuteur(), livre.getIsbn(), livre.getPublication(), livre.getGenre(), livre.getResume(), livre.isStatut());
    }

    public Livre map(LivreDTO livreDTO) {
        return new Livre(livreDTO.getNom(), livreDTO.getAuteur(), livreDTO.getIsbn(), livreDTO.getPublication(), livreDTO.getGenre(), livreDTO.getResume(), livreDTO.isStatut());
    }

}
