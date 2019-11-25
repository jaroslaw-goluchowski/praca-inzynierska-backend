package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.responses.*;
import com.goluchowski.jaroslaw.pracainzynierskabackend.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class DefaultControler {

    @Autowired
    private DefaultService service;

    @GetMapping("/v1/getDruzynyPlusZawodnicy")
    public ResponseEntity<List<DruzynyInfo>> wyswietlWszystkieDruzynyISiatkarzy() {
        return ResponseEntity.ok().body(service.wyswietlDruzyny());
    }

    @GetMapping("/v1/getTabelaNaSezony")
    public ResponseEntity<List<TabelaPerSezon>> wyswietlTabele() {
        return ResponseEntity.ok().body(service.wyswietlTabele());
    }

    @GetMapping("/v1/getSezonyWithSpotkania")
    public ResponseEntity<List<SezonyInfo>> wyswietlSpotkania() {
        return ResponseEntity.ok().body(service.wyswietlSpotkania());
    }

    @PostMapping("/v1/uploadFile")
    public void uploadFile(@RequestParam("zdjecie") MultipartFile zdjecie, @RequestParam("logo") MultipartFile logo, @RequestParam String nazwa,
                           @RequestParam Long data, @RequestParam Long miastoId, @RequestParam Long trenerId ) throws IOException {
        service.uploadFile(zdjecie, logo, nazwa, data, miastoId, trenerId);
    }

}
