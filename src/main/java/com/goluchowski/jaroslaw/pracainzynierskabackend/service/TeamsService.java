package com.goluchowski.jaroslaw.pracainzynierskabackend.service;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsService extends JpaRepository<Teams, Long> {
}
