package com.example.Kontaktbuch.Repositories;

import com.example.Kontaktbuch.Entities.Anschrift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnschriftRepository extends JpaRepository<Anschrift, Long> {
}
