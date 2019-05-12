package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.PlayersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.PlayersService;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayersEndpoint implements PlayersEndpointApi {

    @Autowired
    private PlayersService playersService;

    @Autowired
    private TeamsService teamsService;

//    @Override
//    public List<Player> getAllPlayers() {
//        return playersService.findAll();
//    }
//
//    @Override
//    public ResponseEntity<String> addPlayer(@PathVariable String teamName, @RequestBody Player player) {
//        Optional<Team> team = teamsService.getTeamByName(teamName);
//        if(team.isPresent()){
//            player.setTeam(team.get());
//            playersService.save(player);
//            return new ResponseEntity<>("Player succesfully added", HttpStatus.CREATED);
//        }else {
//            return new ResponseEntity<>("There is no such team", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public ResponseEntity<String> addPlayersList(@PathVariable String teamName, @RequestBody List<Player> players) {
//        Optional<Team> team = teamsService.getTeamByName(teamName);
//        if(team.isPresent()){
//            players.stream().forEach(p->p.setTeam(team.get()));
//            playersService.saveAll(players);
//            return new ResponseEntity<>(players.size() + " players succesfully added", HttpStatus.CREATED);
//        }else {
//            return new ResponseEntity<>("There is no such team", HttpStatus.NOT_FOUND);
//        }
//    }
}
