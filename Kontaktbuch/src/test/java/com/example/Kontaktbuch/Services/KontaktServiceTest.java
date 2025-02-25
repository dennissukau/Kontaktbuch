package com.example.Kontaktbuch.Services;

import TestObjectGenerator.AnschriftGenerator;
import TestObjectGenerator.KontaktGenerator;
import TestObjectGenerator.TelefonnummerGenerator;
import com.example.Kontaktbuch.Entities.Anschrift;
import com.example.Kontaktbuch.Entities.Kontakt;
import com.example.Kontaktbuch.Entities.Telefonnummer;
import com.example.Kontaktbuch.Repositories.KontaktRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KontaktServiceTest {

    private KontaktRepository kontaktRepository;
    private KontaktService kontaktService;
    private KontaktGenerator kontaktGenerator;
    private AnschriftGenerator anschriftGenerator;
    private TelefonnummerGenerator telefonnummerGenerator;

    @AfterEach
    public void cleanUp() {
        kontaktRepository.deleteAll();
    }

    @Test
    void getKontaktById() {
        //Telefon und Anschrift generieren
        var telefon = telefonnummerGenerator.generateRandomTelefonnummer();
        var anschrift = anschriftGenerator.createRandomAnschrift();
        //Telefon und Anschrift Liste und mit vorherigen TestObjekten füllen
        Set<Telefonnummer> telefonListe = new HashSet<>();
        Set<Anschrift> anschriftsListe = new HashSet<>();

        telefonListe.add(telefon);
        anschriftsListe.add(anschrift);
        //Kontakt erstellen und in der Datenbank speichern
        var testKontakt = kontaktGenerator.generateRandomKontakt(anschriftsListe, telefonListe);
        kontaktRepository.save(testKontakt);

        // Kontakt mit der ID holen
        var fetchedKontakt = kontaktService.getKontaktById(testKontakt.getId());

        // Überprüfe, ob der Kontakt richtig abgerufen wurde
        assertNotNull(fetchedKontakt);
        assertEquals(testKontakt.getId(), fetchedKontakt.get().getId());
        assertEquals(testKontakt.getVorname(), fetchedKontakt.get().getVorname());
        assertEquals(testKontakt.getNachname(), fetchedKontakt.get().getNachname());

    }

    @Test
    void findAll() {
        var kontakt1 = kontaktService.createKontakt("Peter", "Mueller", LocalDate.of(2020, 1, 8), new HashSet<>(), new HashSet<>());
        var kontakt2 = kontaktService.createKontakt("Anna", "Morgan", LocalDate.of(2021, 5, 12), new HashSet<>(), new HashSet<>());

        List<Kontakt> alleKontakte = kontaktService.findAll();

        assertNotNull(alleKontakte);
        assertTrue(alleKontakte.size() >= 2);
    }


    @Test
    void updateKontakt() {
    }

    @Test
    void deleteKontakt() {
    }
}


