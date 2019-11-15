package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Siatkarze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface SiatkarzeRepository extends JpaRepository<Siatkarze, Long> {
}
