package com.goluchowski.jaroslaw.pracainzynierskabackend.repository;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Druzyny;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Sezony;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Spotkania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotkaniaRepository extends JpaRepository<Spotkania, Long> {

    @Query(value = "SELECT * FROM spotkania s WHERE (s.gospodarz_id = :gospodarz_id OR s.gosc_id = :gosc_id) AND s.sezon_id = :sezon_id", nativeQuery = true)
    public List<Spotkania> findAllByGoscOrGospodarzAndSezon(Long gospodarz_id, Long gosc_id, Long sezon_id);

}
