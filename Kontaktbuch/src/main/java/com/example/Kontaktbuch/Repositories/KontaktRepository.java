package com.example.Kontaktbuch.Repositories;

import com.example.Kontaktbuch.Entities.Kontakt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktRepository extends JpaRepository<Kontakt, Long> {
}
