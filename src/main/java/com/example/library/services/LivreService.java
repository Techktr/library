package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.mapper.LivreMapper;
import com.example.library.model.Livre;
import com.example.library.repository.LivreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivreService {

    private final LivreRepository livreRepository;
    private final LivreMapper livreMapper;

    public LivreDTO save(LivreDTO livreDTO) {
        Livre livre = livreMapper.toEntity(livreDTO);
        if (livre.getUuid() == null) {
            livre.setUuid(UUID.randomUUID());
        }
        Livre saved = livreRepository.save(livre);
        return livreMapper.toDto(saved);
    }

    public Optional<LivreDTO> findById(UUID id) {
        return livreRepository.findById(id)
                .map(livreMapper::toDto);
    }

    public List<LivreDTO> findAll() {
        return livreMapper.toDtos(livreRepository.findAll());
    }

    public void deleteById(UUID id) {
        livreRepository.deleteById(id);
    }
}