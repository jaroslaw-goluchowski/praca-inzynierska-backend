package com.goluchowski.jaroslaw.pracainzynierskabackend.responses;

import lombok.Data;

import java.util.List;

@Data
public class SezonyInfo {

    private String sezonNazwa;

    private List<SpotkaniaInfo> spotkania;
}
