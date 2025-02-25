package TestObjectGenerator;

import com.example.Kontaktbuch.Entities.Anschrift;
import com.example.Kontaktbuch.Entities.Kontakt;
import com.example.Kontaktbuch.Entities.Telefonnummer;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class KontaktGenerator {
    public Kontakt generateRandomKontakt(Set<Anschrift> anschriften, Set<Telefonnummer> telefonnummern) {

        var randomVorname = randomAlphanumeric(8);
        var randomNachname = randomAlphanumeric(8);


        return Kontakt.builder()
                .vorname(randomVorname)
                .nachname(randomNachname)
                .geburtsdatum(LocalDate.now())
                .anschriften(anschriften)
                .telefonnummern(telefonnummern)
                .build();

    }
}
