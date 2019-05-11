package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;


import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TrainersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainers;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainersEndpoint implements TrainersEndpointApi {

    @Autowired
    private TrainersService trainersService;


    @GetMapping("/trainers")
    public List<Trainers> getAllTrainers(){
        return trainersService.findAll();
    }

    @GetMapping("/trainers/{lastName}")
    public Trainers getByLastName(@Valid @PathVariable  String lastName){
        Optional<Trainers> trainer = trainersService.getTrainerByLastName(lastName);
        if(trainer.isPresent()){
            return trainer.get();
        }else {
            return null;
        }
    }

    @PostMapping("/trainers")
    public ResponseEntity<String> insertOrUpadteTrainer(@Valid @RequestBody Trainers trainer){
        trainersService.save(trainer);
        return new ResponseEntity<>("Succesfully added trainer", HttpStatus.CREATED);
    }

    @PostMapping("/trainers/list")
    public ResponseEntity<String> insertOrUpadteTrainerList(@Valid @RequestBody List<Trainers> trainers){
        trainersService.saveAll(trainers);
        return new ResponseEntity<>("Succesfully added " + trainers.size() + " trainers", HttpStatus.CREATED);
    }





}
