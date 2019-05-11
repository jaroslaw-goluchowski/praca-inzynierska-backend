package com.goluchowski.jaroslaw.pracainzynierskabackend.service;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trainers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainersService extends JpaRepository<Trainers, Long> {

    public Optional<Trainers> getTrainerByLastname(String lastName);

}
