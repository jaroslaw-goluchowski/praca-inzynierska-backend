package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface TrainersEndpointApi {

    @ApiOperation("Get list of trainers")
    @GetMapping("/trainers")
    public List<Trainer> getAllTrainers();

    @ApiOperation("Get trainer by lastName")
    @GetMapping("/trainers/{lastName}")
    public Trainer getByLastName(@ApiParam(value = "Last Name of trainer", required = true) @PathVariable String lastName);

    @ApiOperation("Add a trainer")
    @PostMapping("/trainers")
    public ResponseEntity<String> insertOrUpadteTrainer(@ApiParam(value = "Trainer object", required = true) @RequestBody Trainer trainer);

    @ApiOperation("Add trainers list")
    @PostMapping("/trainers/list")
    public ResponseEntity<String> insertOrUpadteTrainerList(@ApiParam(value = "List of Trainers objects", required = true) @RequestBody List<Trainer> trainers);

}
