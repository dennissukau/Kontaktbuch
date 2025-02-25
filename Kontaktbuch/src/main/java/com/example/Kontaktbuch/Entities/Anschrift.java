package com.example.Kontaktbuch.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Anschrift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String straßenName;
    private int hausNummer;
    private String postleitzahl;
    private String ort;
    private KontaktTyp anschriftTyp;
    @ManyToOne
    @JoinColumn(name = "kontakt_id")
    private Kontakt kontakt;

}
