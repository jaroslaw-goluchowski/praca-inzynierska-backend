package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trenerzy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TrenerzyRepository extends JpaRepository<Trenerzy, Long> {
}
