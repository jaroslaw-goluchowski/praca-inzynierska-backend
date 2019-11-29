package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Sedziowie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedziowieRepository extends JpaRepository<Sedziowie, Long> {
    Sedziowie findByNazwisko(String nazwisko);
}
