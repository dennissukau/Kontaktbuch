package com.example.Kontaktbuch.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Telefonnummer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String laendervorwahl;
    private String ortsOderMobilVorwahl;
    private KontaktTyp kontaktTyp;
    @ManyToOne
    @JoinColumn(name = "kontakt_id")
    private Kontakt kontakt;
}
