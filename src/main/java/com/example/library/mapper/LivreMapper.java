package com.example.library.mapper;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivreMapper {

    public LivreMapper() {}

    public LivreDTO toDto(Livre livre) {
        return new LivreDTO(livre.getNom(), livre.getAuteur(), livre.getIsbn(), livre.getPublication(), livre.getGenre(), livre.getResume(), livre.isStatut());
    }

    public Livre toEntity(LivreDTO livreDTO) {
        return new Livre(livreDTO.getNom(), livreDTO.getAuteur(), livreDTO.getIsbn(), livreDTO.getPublication(), livreDTO.getGenre(), livreDTO.getResume(), livreDTO.isStatut());
    }

    public List<LivreDTO> toDtos(List<Livre> livreList) {
        return livreList.stream().map(this::toDto).toList();
    }

    public List<Livre> toEntities(List<LivreDTO> livreDTOList) {
        return livreDTOList.stream().map(this::toEntity).toList();
    }

}
