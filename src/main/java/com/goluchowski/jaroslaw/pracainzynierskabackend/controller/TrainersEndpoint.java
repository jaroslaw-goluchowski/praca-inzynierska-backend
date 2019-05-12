package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;


import com.goluchowski.jaroslaw.pracainzynierskabackend.api.TrainersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainer;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class TrainersEndpoint implements TrainersEndpointApi {

    @Autowired
    private TrainersService trainersService;

    @Override
    public List<Trainer> getAllTrainers() {
        return trainersService.findAll();
    }

    @Override
    public ResponseEntity<String> insertTrainer(@Valid @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestBody Trainer trainer) {
        Optional<Trainer> optional = trainersService.findByFirstNameAndLastNameAndDateOfBirth(trainer.getFirstName(),
                trainer.getLastName(), trainer.getDateOfBirth());

        if(optional.isPresent()){
            return ResponseEntity.badRequest().body("Trainer already in db");
        }

        trainersService.save(trainer);
        return new ResponseEntity<>("Trainer added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> insertTrainerList(List<Trainer> trainers) {
        AtomicBoolean exists = new AtomicBoolean(false);
        trainers.forEach(t -> {
            Optional<Trainer> optional = trainersService.findByFirstNameAndLastNameAndDateOfBirth(t.getFirstName(),
                    t.getLastName(), t.getDateOfBirth());
            if(optional.isPresent()){
                exists.set(true);
            }
        });
        if(exists.get()){
            return ResponseEntity.badRequest().body("Trainer already in db");
        }
        trainersService.saveAll(trainers);
        return new ResponseEntity<>(trainers.size() + " trainers added ", HttpStatus.CREATED);
    }
}
