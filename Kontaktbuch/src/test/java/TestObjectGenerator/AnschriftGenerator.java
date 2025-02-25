package TestObjectGenerator;

import com.example.Kontaktbuch.Entities.Anschrift;
import com.example.Kontaktbuch.Entities.KontaktTyp;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class AnschriftGenerator {

    Random random = new Random();

    public Anschrift createRandomAnschrift() {
        return Anschrift.builder()
                .straßenName("Musterstraße")
                .hausNummer(random.nextInt(100))
                .ort(randomAlphanumeric(5))
                .anschriftTyp(KontaktTyp.GESCHAEFTLICH)
                .postleitzahl(String.valueOf(random.nextInt(50000)))
                .build();
    }
}
