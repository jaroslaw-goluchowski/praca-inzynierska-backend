package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface TeamsEndpointApi {

    @ApiOperation("Get list of teams")
    @GetMapping("/teams")
    public List<Team> getAllTeams();

    @ApiOperation("Get all players for specific team name")
    @GetMapping("/teams/players/{teamName}")
    public Set<Player> getAllTeamPlayers(@ApiParam(value = "Name of team") @PathVariable String teamName);

    @ApiOperation("Get team for given name")
    @GetMapping("/teams/{teamName}")
    public Team getByName(@ApiParam(value = "Name of team") @PathVariable String teamName);
}
