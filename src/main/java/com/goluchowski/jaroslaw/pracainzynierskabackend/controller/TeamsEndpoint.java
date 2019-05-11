package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TeamsEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamsEndpoint implements TeamsEndpointApi {

    @Autowired
    private TeamsService teamsService;

    @Override
    public List<Team> getAllTeams() {
        return teamsService.findAll();
    }
}
