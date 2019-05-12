package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.PlayersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.PlayersService;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TeamsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.REException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayersEndpoint implements PlayersEndpointApi {

    @Autowired
    private PlayersService playersService;

    @Autowired
    private TeamsService teamsService;

    @Override
    public List<Player> getAllPlayers(){
        return playersService.findAll();
    }


    @Override
    public ResponseEntity<String> addPlayer(@NotNull @PathVariable String teamName, @RequestBody Player player){
        Optional<Player> playerOptional = playersService.findByFirstNameAndLastNameAndDateOfBirth(player.getFirstName(),
                player.getLastName(), player.getDateOfBirth());
        if(playerOptional.isPresent()){
            return ResponseEntity.badRequest().body("There is already such player in database");
        }
        Optional<Team> team = teamsService.getTeamByName(teamName);
        if(team.isPresent()){
            player.setTeam(team.get());
            playersService.save(player);
            return new ResponseEntity<>("Player added", HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body("There is no team for specified team name");
    }
}
