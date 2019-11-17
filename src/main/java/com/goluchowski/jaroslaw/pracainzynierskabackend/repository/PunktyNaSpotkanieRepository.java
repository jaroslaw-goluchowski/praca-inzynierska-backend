package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.PunktyNaSpotkanie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PunktyNaSpotkanieRepository extends JpaRepository<PunktyNaSpotkanie, Long> {

        @Query(value = "SELECT * FROM punkty p WHERE p.spotkanie_id = :spotkanieId", nativeQuery = true)
        public List<PunktyNaSpotkanie> findAllBySpotkanie(Long spotkanieId);
}
