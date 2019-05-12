package com.goluchowski.jaroslaw.pracainzynierskabackend.service;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersService extends JpaRepository<Player, Long> {

}
