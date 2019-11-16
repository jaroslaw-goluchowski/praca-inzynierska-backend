package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.PunktyNaSpotkanie;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Spotkania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PunktyNaSpotkanieRepository extends JpaRepository<PunktyNaSpotkanie, Long> {
        public List<PunktyNaSpotkanie> findAllBySpotkanie(Spotkania spotkanie);
}
