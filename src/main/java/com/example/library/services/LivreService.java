package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.mapper.LivreMapper;
import com.example.library.model.Livre;
import com.example.library.repository.LivreRepository;
import org.springframework.stereotype.Service;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    private final LivreMapper livreMapper =  new LivreMapper();

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public Livre createBook(LivreDTO livreDTO) {
        return livreRepository.save(livreMapper.map(livreDTO));
    }

    public Livre saveBook(LivreDTO livreDTO) {
        return livreRepository.save(livreMapper.map(livreDTO));
    }
}
