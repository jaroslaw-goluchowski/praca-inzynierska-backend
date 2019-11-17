package com.goluchowski.jaroslaw.pracainzynierskabackend.api;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trenerzy;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



public interface TrainersEndpointApi {

    @ApiOperation("Get list of trainers")
    @GetMapping("/trainers")
    public List<Trenerzy> getAllTrainers();


    @ApiOperation("Add a trainer")
    @PostMapping("/trainers")
    public ResponseEntity<String> insertTrainer(@ApiParam(value = "Trainer object", required = true)
                                                    @RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") Trenerzy trenerzy);

    @ApiOperation("Add trainers list")
    @PostMapping("/trainers/list")
    public ResponseEntity<String> insertTrainerList(@ApiParam(value = "List of Trainers objects", required = true)
                                                                @RequestBody List<Trenerzy> trenerzies);

}
