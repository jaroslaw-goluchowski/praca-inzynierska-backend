package com.goluchowski.jaroslaw.pracainzynierskabackend.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Siatkarze;
import lombok.Data;

import java.util.List;

@Data
public class DruzynyInfo {

    private String nazwa_druzyny;

    private Long data_zalozenia;

    @JsonIgnore
    private byte[] zdjecie_druzynowe;

    private byte[] logo;

    private String nazwa_miasta;

    private String imie_trenera;

    private String nazwisko_trenera;

    private List<Siatkarze> lista_siatkarzy;

}
