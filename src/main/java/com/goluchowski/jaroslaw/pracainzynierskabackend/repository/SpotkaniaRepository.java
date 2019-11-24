package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Druzyny;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Spotkania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotkaniaRepository extends JpaRepository<Spotkania, Long> {

    public List<Spotkania> findAllByGoscOrGospodarz(Druzyny druzyna, Druzyny druzyna2);
}