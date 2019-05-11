package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Team;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface TeamsEndpointApi {

    @ApiOperation("Get list of teams")
    @GetMapping("/teams")
    public List<Team> getAllTeams();
}
