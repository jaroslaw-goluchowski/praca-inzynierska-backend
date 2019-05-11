package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface PlayersEndpointApi {

    @ApiOperation("Get list of players")
    @GetMapping("/players")
    public List<Player> getAllPlayers();
}
