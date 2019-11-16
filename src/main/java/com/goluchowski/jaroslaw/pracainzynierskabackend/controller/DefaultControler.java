package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.PunktyNaSpotkanie;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.PunktyNaSpotkanieRepository;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.DruzynyInfo;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.SpotkaniaInfo;
import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.Tabela;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultControler {

    @Autowired
    private DefaultService service;

    @Autowired
    private PunktyNaSpotkanieRepository punktyNaSpotkanieRepository;

    @GetMapping("/getDruzynyPlusZawodnicy")
    public ResponseEntity<List<DruzynyInfo>> wyswietlWszystkieDruzynyISiatkarzy() {
        return ResponseEntity.ok().body(service.wyswietlDruzyny());
    }

    @GetMapping("/getTabela")
    public ResponseEntity<List<Tabela>> wyswietlTabele() {
        return ResponseEntity.ok().body(service.wyswietlTabele());
    }

    @GetMapping("/getSpotkania")
    public ResponseEntity<List<SpotkaniaInfo>> wyswietlSpotkania() {
        return ResponseEntity.ok().body(service.wyswietlSpotkania());
    }

    @GetMapping("/getAllBySpotkanie")
    public List<PunktyNaSpotkanie> findAllBySpotkanie() {
        return punktyNaSpotkanieRepository.findAll();
    }

}
