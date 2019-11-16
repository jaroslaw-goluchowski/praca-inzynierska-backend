package com.goluchowski.jaroslaw.pracainzynierskabackend.responses;
import lombok.Data;

@Data
public class Tabela {

    private String nazwa_druzyny;

    private int punkty;

    private int mecze_rozegrane;

    private int mecze_wygrane;

    private int mecze_przegrane;
}
