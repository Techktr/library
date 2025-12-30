package com.example.library.mapper;

import com.example.library.dto.LivreDTO;
import com.example.library.model.Livre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


public class LivreMapperTest {

    private LivreMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new LivreMapper();
    }

    @Test
    public void toDto() {
        Date publicationDate = new Date(2008, Calendar.AUGUST, 1);
        Livre livre = new Livre("Clean Code", "Robert Martin", "ISBN-13. 978-0132350884", publicationDate, "Informatique", "Si un code «sale» peut fonctionner, il peut également remettre en question la pérennité d'une entreprise de développement de logiciels. Chaque année, du temps et des ressources sont gaspillés à cause d'un code mal écrit.",true);
        LivreDTO response = this.mapper.toDto(livre);

        // assertEquals(new LivreDTO("Clean Code", "Robert Martin", "ISBN-13. 978-0132350884", Date.from(Instant.now()), "Informatique", "Si un code «sale» peut fonctionner, il peut également remettre en question la pérennité d'une entreprise de développement de logiciels. Chaque année, du temps et des ressources sont gaspillés à cause d'un code mal écrit.",true), response);
        assertThat(response).usingRecursiveComparison().isEqualTo(new LivreDTO("Clean Code", "Robert Martin", "ISBN-13. 978-0132350884", publicationDate, "Informatique", "Si un code «sale» peut fonctionner, il peut également remettre en question la pérennité d'une entreprise de développement de logiciels. Chaque année, du temps et des ressources sont gaspillés à cause d'un code mal écrit.",true));
    }

    @Test
    public void toEntity() {
        Date publicationDate = new Date(2008, Calendar.AUGUST, 1);
        LivreDTO livreDTO = new LivreDTO("Clean Code", "Robert Martin", "ISBN-13. 978-0132350884", publicationDate, "Informatique", "Si un code «sale» peut fonctionner, il peut également remettre en question la pérennité d'une entreprise de développement de logiciels. Chaque année, du temps et des ressources sont gaspillés à cause d'un code mal écrit.",true);
        Livre response = this.mapper.toEntity(livreDTO);
        assertThat(response).usingRecursiveComparison().isEqualTo(new Livre("Clean Code", "Robert Martin", "ISBN-13. 978-0132350884", publicationDate, "Informatique", "Si un code «sale» peut fonctionner, il peut également remettre en question la pérennité d'une entreprise de développement de logiciels. Chaque année, du temps et des ressources sont gaspillés à cause d'un code mal écrit.",true));
    }


}
