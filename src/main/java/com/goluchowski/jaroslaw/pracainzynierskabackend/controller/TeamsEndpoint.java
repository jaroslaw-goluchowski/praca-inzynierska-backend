package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TeamsEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TrainersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Teams;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamsEndpoint implements TeamsEndpointApi {

    @Autowired
    private TeamsService teamsService;

    @Override
    public List<Teams> getAllTeams() {
        return teamsService.findAll();
    }
}
