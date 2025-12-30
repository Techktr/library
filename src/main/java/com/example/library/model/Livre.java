package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor  // ← Ajoute ça !
@AllArgsConstructor
@Builder
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID uuid;
    public String nom;
    public String auteur;
    public String isbn;
    public Date publication;
    public String genre;
    public String resume;
    public boolean statut;

    public Livre(String nom, String auteur, String isbn, Date publication, String genre, String resume, boolean statut) {
        this.nom = nom;
        this.auteur = auteur;
        this.isbn = isbn;
        this.publication = publication;
        this.genre = genre;
        this.resume = resume;
        this.statut = statut;
    }
}
