package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface PlayersEndpointApi {

    @ApiOperation("Get list of players")
    @GetMapping("/players")
    public List<Player> getAllPlayers();


    @ApiOperation("Insert player to database")
    @PostMapping("/players/{teamName}")
    public ResponseEntity<String> addPlayer(@NotNull @ApiParam(value = "Name of team")@PathVariable String teamName,
                                            @ApiParam(value = "Player info") @RequestBody Player player);
//
//    @ApiOperation("Insert players to database")
//    @PostMapping("/players/list/{teamName}")
//    public ResponseEntity<String> addPlayersList(@ApiParam(value = "Name of team")@PathVariable String teamName,
//                                                 @ApiParam(value = "List of players info")@RequestBody List<Player> players);

}
