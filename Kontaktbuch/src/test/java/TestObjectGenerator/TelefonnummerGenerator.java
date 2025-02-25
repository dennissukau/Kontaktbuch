package TestObjectGenerator;

import com.example.Kontaktbuch.Entities.Kontakt;
import com.example.Kontaktbuch.Entities.KontaktTyp;
import com.example.Kontaktbuch.Entities.Telefonnummer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Random;

public class TelefonnummerGenerator {

    public Telefonnummer generateRandomTelefonnummer() {
        var random = new Random();
        var randomLaendervorwahl = String.valueOf(100 + random.nextInt(800));
        var randomOrtsOderMobilVorwahl = String.valueOf(70000 + random.nextInt(50000));

        return Telefonnummer.builder()
                .kontaktTyp(KontaktTyp.PRIVAT)
                .laendervorwahl(randomLaendervorwahl)
                .ortsOderMobilVorwahl(randomOrtsOderMobilVorwahl)
                .build();
    }
}
