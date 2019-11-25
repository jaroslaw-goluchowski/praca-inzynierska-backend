package com.goluchowski.jaroslaw.pracainzynierskabackend.responses;

import lombok.Data;

import java.util.List;

@Data
public class TabelaPerSezon {

    private String nazwaSezonu;

    private List<Tabela> tabela;
}
