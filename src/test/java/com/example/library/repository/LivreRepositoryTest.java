package com.example.library.repository;

import com.example.library.model.Livre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // Lance une base H2 en mémoire
class LivreRepositoryTest {

    @Autowired
    private LivreRepository livreRepository;

    @Test
    void save_shouldPersistLivre() {
        // Arrange
        Livre livre = createLivre("Clean Code", "Robert Martin");

        // Act
        Livre saved = livreRepository.save(livre);

        // Assert
        assertThat(saved.getUuid()).isNotNull();
        assertThat(saved.getNom()).isEqualTo("Clean Code");
    }

    @Test
    void findById_shouldReturnLivre() {
        // Arrange
        Livre livre = livreRepository.save(createLivre("Clean Code", "Robert Martin"));

        // Act
        Optional<Livre> found = livreRepository.findById(livre.getUuid());

        // Assert
        assertThat(found).isPresent();
        assertThat(found.get().getNom()).isEqualTo("Clean Code");
    }

    @Test
    void findByAuteur_shouldReturnLivresByAuthor() {
        // Arrange
        livreRepository.save(createLivre("Clean Code", "Robert Martin"));
        livreRepository.save(createLivre("Clean Architecture", "Robert Martin"));
        livreRepository.save(createLivre("Effective Java", "Joshua Bloch"));

        // Act
        List<Livre> result = livreRepository.findByAuteur("Robert Martin");

        // Assert
        assertThat(result)
                .hasSize(2)
                .extracting("nom")
                .containsExactlyInAnyOrder("Clean Code", "Clean Architecture");
    }

    @Test
    void delete_shouldRemoveLivre() {
        // Arrange
        Livre livre = livreRepository.save(createLivre("Clean Code", "Robert Martin"));

        // Act
        livreRepository.delete(livre);

        // Assert
        assertThat(livreRepository.findById(livre.getUuid())).isEmpty();
    }

    @Test
    void findAll_shouldReturnAllLivres() {
        // Arrange
        livreRepository.save(createLivre("Clean Code", "Robert Martin"));
        livreRepository.save(createLivre("Effective Java", "Joshua Bloch"));

        // Act
        List<Livre> result = livreRepository.findAll();

        // Assert
        assertThat(result).hasSize(2);
    }

    // Helper method
    private Livre createLivre(String nom, String auteur) {
        return Livre.builder()
                .nom(nom)
                .auteur(auteur)
                .isbn("ISBN-123")
                .publication(Date.from(LocalDate.of(2008, 8, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .genre("Informatique")
                .resume("Un excellent livre")
                .statut(true)
                .build();
    }
}