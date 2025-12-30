package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class LivreDTO {
    public String nom;
    public String auteur;
    public String isbn;
    public Date publication;
    public String genre;
    public String resume;
    public boolean statut;
}
