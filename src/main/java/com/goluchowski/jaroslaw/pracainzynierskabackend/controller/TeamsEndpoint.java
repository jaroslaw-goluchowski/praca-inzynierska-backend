package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TeamsEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainer;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TeamsService;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

@RestController
public class TeamsEndpoint implements TeamsEndpointApi {

    @Autowired
    private TeamsService teamsService;

    @Autowired
    private TrainersService trainersService;

    @Override
    public List<Team> getAllTeams() {
        return teamsService.findAll();
    }

    @Override
    public ResponseEntity<String> addTeam(@NotNull @PathVariable Long trainerId, @Valid @RequestBody Team team) {
        Optional<Team> teamByName = teamsService.getTeamByName(team.getName());

        if(teamByName.isPresent()){
            return ResponseEntity.badRequest().body("There is alrady team with that name in database");
        }

        Optional<Trainer> trainer = trainersService.findById(trainerId);

        if(trainer.isPresent()){
            if(trainer.get().getTeam() == null){
                trainer.get().setTeam(team);
                teamsService.save(team);
                trainersService.save(trainer.get());
                return new ResponseEntity<>("Added a team", HttpStatus.CREATED);
            }else {
                return ResponseEntity.badRequest().body("That trainer already has a team");
            }
        }
        return ResponseEntity.badRequest().body("There is trainer with that ID");
    }
}
