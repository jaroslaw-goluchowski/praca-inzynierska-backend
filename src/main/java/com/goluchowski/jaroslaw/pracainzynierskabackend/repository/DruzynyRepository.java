package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Druzyny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DruzynyRepository extends JpaRepository<Druzyny, Long> {
}
