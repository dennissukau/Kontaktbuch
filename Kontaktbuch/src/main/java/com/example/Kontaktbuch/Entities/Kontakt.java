package com.example.Kontaktbuch.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Kontakt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    @OneToMany
    @JoinColumn(name = "kontakt_id")
    private Set<Anschrift> anschriften;
    @OneToMany
    @JoinColumn(name = "kontakt_id")
    private Set<Telefonnummer> telefonnummern;
}
