package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trenerzy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrenerzyRepository extends JpaRepository<Trenerzy, Long> {
    Trenerzy findByNazwisko(String nazwisko);
}
