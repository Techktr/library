package com.example.library.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data

public class Livre {
    public UUID uuid;
    public String nom;
    public String auteur;
    public String isbn;
    public Date publication;
    public String genre;
    public String resume;
    public boolean statut;

    public Livre(String nom, String auteur, String isbn, Date publication, String genre, String resume, boolean statut) {
        this.uuid = UUID.randomUUID();
        this.nom = nom;
        this.auteur = auteur;
        this.isbn = isbn;
        this.publication = publication;
        this.genre = genre;
        this.resume = resume;
        this.statut = statut;
    }
}
