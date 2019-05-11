package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TeamsEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TeamsEndpoint implements TeamsEndpointApi {

    @Autowired
    private TeamsService teamsService;

    @Override
    public List<Team> getAllTeams() {
        return teamsService.findAll();
    }

    public Set<Player> getAllTeamPlayers(@PathVariable String teamName){
        Optional<Team> team = teamsService.getTeamByName(teamName);
        if(team.isPresent()){
            return team.get().getPlayers();
        }else{
            return null;
        }
    }

    @Override
    public Team getByName(@PathVariable String teamName) {
        Optional<Team> team = teamsService.getTeamByName(teamName);
        if(team.isPresent()){
            return team.get();
        }else{
            return null;
        }
    }

}
