package com.goluchowski.jaroslaw.pracainzynierskabackend.service;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PlayersService extends JpaRepository<Player, Long> {
    public Optional<Player> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);

}
