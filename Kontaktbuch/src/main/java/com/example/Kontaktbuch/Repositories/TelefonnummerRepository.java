package com.example.Kontaktbuch.Repositories;

import com.example.Kontaktbuch.Entities.Telefonnummer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonnummerRepository extends JpaRepository<Telefonnummer, Long> {
}
