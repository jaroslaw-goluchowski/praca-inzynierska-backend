package com.goluchowski.jaroslaw.pracainzynierskabackend.responses;
import lombok.Data;

import java.util.List;

@Data
public class SpotkaniaInfo {

    private Long data_spotkania;

    private String nazwa_miasta;

    private String imie_sedziego;

    private String nazwisko_sedziego;

    private String nazwa_gospodarza;

    private String nazwa_gosca;

    private int sety_gospodarze;

    private int sety_goscie;

    private List<SpotkanieDetails> szczegoly;
}

