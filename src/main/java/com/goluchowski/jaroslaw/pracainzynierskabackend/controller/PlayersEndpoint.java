package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.api.PlayersEndpointApi;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Druzyny;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Siatkarze;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.SiatkarzeRepository;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.DruzynyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayersEndpoint {
}
