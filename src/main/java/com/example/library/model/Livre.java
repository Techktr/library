package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data

public class Livre {
    public UUID uuid;
    public String nom;
    public String auteur;

    public Livre(String nom, String auteur) {
        this.uuid = UUID.randomUUID();
        this.nom = nom;
        this.auteur = auteur;
    }
}
