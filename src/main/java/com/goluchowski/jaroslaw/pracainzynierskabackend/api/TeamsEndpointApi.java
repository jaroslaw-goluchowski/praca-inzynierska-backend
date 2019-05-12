package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Player;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public interface TeamsEndpointApi {

//    @ApiOperation("Get list of teams")
//    @GetMapping("/teams")
//    public List<Team> getAllTeams();
//
//    @ApiOperation("Get all players for specific team name")
//    @GetMapping("/teams/players/{teamName}")
//    public Set<Player> getAllTeamPlayers(@ApiParam(value = "Name of team") @PathVariable String teamName);
//
//    @ApiOperation("Get team for given name")
//    @GetMapping("/teams/{teamName}")
//    public ResponseEntity<Team> getByName(@ApiParam(value = "Name of team") @PathVariable String teamName);
//
//    @ApiOperation("Add team to database")
//    @PostMapping("/teams/{trainerId}")
//    public ResponseEntity<String> addTeam(@ApiParam(value = "Trainer ID")@PathVariable Long trainerId,
//                                          @ApiParam(value = "Team info") @RequestBody Team team);
//
//    @ApiOperation("Add list of teams to database")
//    @PostMapping("/teams/list/{trainerId}")
//    public ResponseEntity<String> addTeamList(@ApiParam(value = "Trainer ID")@PathVariable Long trainerId,
//                                          @ApiParam(value = "List of Teams info") @RequestBody List<Team> teams);

}
