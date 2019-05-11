package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;


import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainers;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.TrainersService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainersEndpoint {

    private TrainersService trainersService;

    @GetMapping("/trainers")
    public List<Trainers> getAllTrainers(){
        return trainersService.findAll();
    }

    @GetMapping("/trainers/{lastName}")
    public Trainers getByLastName(@PathVariable  String lastName){
        Optional<Trainers> trainer = trainersService.getTrainerByLastname(lastName);
        if(trainer.isPresent()){
            return trainer.get();
        }else {
            return null;
        }
    }

    @PostMapping("/trainers")
    public void insertOrUpadteTrainer(@RequestBody Trainers trainer){
        trainersService.save(trainer);
    }

    @PostMapping("/trainers/list")
    public void insertOrUpadteTrainerList(@RequestBody List<Trainers> trainers){
        trainersService.saveAll(trainers);
    }





}
