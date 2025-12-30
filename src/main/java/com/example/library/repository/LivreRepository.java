package com.example.library.repository;

import com.example.library.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivreRepository extends JpaRepository<Livre, UUID> {

    List<Livre> findByAuteur(String auteur);
    List<Livre> findByGenre(String genre);
    Optional<Livre> findByIsbn(String isbn);
    List<Livre> findByStatutTrue();
}
