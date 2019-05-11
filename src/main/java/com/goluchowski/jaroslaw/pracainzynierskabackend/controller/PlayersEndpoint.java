package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.PlayersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayersEndpoint implements PlayersEndpointApi {

    @Autowired
    private PlayersService playersService;

    @Override
    public List<Player> getAllPlayers() {
        return playersService.findAll();
    }
}
