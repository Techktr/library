package com.example.library.services;

import com.example.library.dto.LivreDTO;
import com.example.library.mapper.LivreMapper;
import com.example.library.model.Livre;
import com.example.library.repository.LivreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LivreServiceTest {

    @Mock
    private LivreRepository livreRepository;

    @Mock
    private LivreMapper livreMapper;

    @InjectMocks
    private LivreService livreService;

    @Test
    void save_shouldGenerateUuidAndSaveBook() {
        // Arrange
        LivreDTO inputDto = createLivreDTO();
        Livre entityWithoutUuid = createLivreWithoutUuid();
        Livre savedEntity = createLivreWithUuid();
        LivreDTO expectedDto = createLivreDTO();

        when(livreMapper.toEntity(inputDto)).thenReturn(entityWithoutUuid);
        when(livreRepository.save(any(Livre.class))).thenReturn(savedEntity);
        when(livreMapper.toDto(savedEntity)).thenReturn(expectedDto);

        // Act
        LivreDTO result = livreService.save(inputDto);

        // Assert
        assertThat(result).isNotNull();
        verify(livreMapper).toEntity(inputDto);
        verify(livreRepository).save(any(Livre.class));
        verify(livreMapper).toDto(savedEntity);
    }

    @Test
    void findById_shouldReturnBookWhenExists() {
        // Arrange
        UUID uuid = UUID.randomUUID();
        Livre livre = createLivreWithUuid();
        LivreDTO expectedDto = createLivreDTO();

        when(livreRepository.findById(uuid)).thenReturn(Optional.of(livre));
        when(livreMapper.toDto(livre)).thenReturn(expectedDto);

        // Act
        Optional<LivreDTO> result = livreService.findById(uuid);

        // Assert
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(expectedDto);
        verify(livreRepository).findById(uuid);
    }

    @Test
    void findById_shouldReturnEmptyWhenNotExists() {
        // Arrange
        UUID uuid = UUID.randomUUID();
        when(livreRepository.findById(uuid)).thenReturn(Optional.empty());

        // Act
        Optional<LivreDTO> result = livreService.findById(uuid);

        // Assert
        assertThat(result).isEmpty();
        verify(livreRepository).findById(uuid);
        verify(livreMapper, never()).toDto(any());
    }

    @Test
    void findAll_shouldReturnAllBooks() {
        // Arrange
        List<Livre> livres = List.of(createLivreWithUuid(), createLivreWithUuid());
        List<LivreDTO> expectedDtos = List.of(createLivreDTO(), createLivreDTO());

        when(livreRepository.findAll()).thenReturn(livres);
        when(livreMapper.toDtos(livres)).thenReturn(expectedDtos);

        // Act
        List<LivreDTO> result = livreService.findAll();

        // Assert
        assertThat(result).hasSize(2);
        verify(livreRepository).findAll();
        verify(livreMapper).toDtos(livres);
    }

    @Test
    void deleteById_shouldCallRepository() {
        // Arrange
        UUID uuid = UUID.randomUUID();

        // Act
        livreService.deleteById(uuid);

        // Assert
        verify(livreRepository).deleteById(uuid);
    }

    // Helper methods
    private LivreDTO createLivreDTO() {
        return LivreDTO.builder()
                .nom("Clean Code")
                .auteur("Robert Martin")
                .isbn("ISBN-123")
                .publication(createDate())
                .genre("Informatique")
                .resume("Un excellent livre")
                .statut(true)
                .build();
    }

    private Livre createLivreWithoutUuid() {
        return Livre.builder()
                .nom("Clean Code")
                .auteur("Robert Martin")
                .isbn("ISBN-123")
                .publication(createDate())
                .genre("Informatique")
                .resume("Un excellent livre")
                .statut(true)
                .build();
    }

    private Livre createLivreWithUuid() {
        return Livre.builder()
                .uuid(UUID.randomUUID())
                .nom("Clean Code")
                .auteur("Robert Martin")
                .isbn("ISBN-123")
                .publication(createDate())
                .genre("Informatique")
                .resume("Un excellent livre")
                .statut(true)
                .build();
    }

    private Date createDate() {
        return Date.from(LocalDate.of(2008, 8, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());
    }
}