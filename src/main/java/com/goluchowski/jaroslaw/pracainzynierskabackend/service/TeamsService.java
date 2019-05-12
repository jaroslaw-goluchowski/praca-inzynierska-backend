package com.goluchowski.jaroslaw.pracainzynierskabackend.service;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamsService extends JpaRepository<Team, Long> {

    public Optional<Team> getTeamByName(String name);


}
