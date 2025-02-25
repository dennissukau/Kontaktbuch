package com.example.Kontaktbuch.Services;

import com.example.Kontaktbuch.Entities.Anschrift;
import com.example.Kontaktbuch.Entities.Kontakt;
import com.example.Kontaktbuch.Entities.Telefonnummer;
import com.example.Kontaktbuch.Repositories.AnschriftRepository;
import com.example.Kontaktbuch.Repositories.KontaktRepository;
import com.example.Kontaktbuch.Repositories.TelefonnummerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class KontaktService {

    private final AnschriftRepository anschriftRepository;
    private final KontaktRepository kontaktRepository;
    private final TelefonnummerRepository telefonnummerRepository;

    public Optional<Kontakt> getKontaktById(long id) {
        return kontaktRepository.findById(id);
    }

    public List<Kontakt> findAll() {
        return kontaktRepository.findAll();
    }

    public void createKontakt(String vorname, String nachname, LocalDate geburtstag, Set<Anschrift> anschriften, Set<Telefonnummer> telefonnummern) {
        var contactToCreate = Kontakt.builder()
                .vorname(vorname)
                .nachname(nachname)
                .geburtsdatum(geburtstag)
                .anschriften(anschriften)
                .telefonnummern(telefonnummern)
                .build();

        kontaktRepository.save(contactToCreate);
    }

    @Transactional
    public Optional<Kontakt> updateKontakt(Long contactId, String vorname, String nachname, LocalDate geburtstag, Set<Anschrift> anschriften) {
        //Prüfung ob Kontakt bereits existiert
        Optional<Kontakt> existingKontakt = kontaktRepository.findById(contactId);
        if (existingKontakt.isPresent()) {
            var kontakt = existingKontakt.get();
            kontakt.setVorname(vorname);
            kontakt.setNachname(nachname);
            kontakt.setAnschriften(anschriften);
            kontakt.setGeburtsdatum(geburtstag);

            return Optional.of(kontaktRepository.save(kontakt));
        }
        //Return Optional mit keinem Kontakt da es nicht zum updaten gibt. Zusätzlich könnte man noch ein Kontakt automatisch hinzufügen mit allen Parametern.
        return existingKontakt;
    }

    @Transactional
    public void deleteKontakt(long contactId) {
        var contactToDelete = kontaktRepository.findById(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Kontakt wurde nicht gefunden"));
    }

}
