package com.goluchowski.jaroslaw.pracainzynierskabackend.responses;

import lombok.Data;

@Data
public class SpotkanieDetails {

    private String imie_siatkarza;

    private String nazwisko_siatkarza;

    private int punkty;

    private String nazwa_druzyny;
}
