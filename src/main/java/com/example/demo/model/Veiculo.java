package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        @JsonAlias("Marca") String marca,
        @JsonAlias("Valor") String valor,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer anoModelo,
        @JsonAlias("Combustivel") String combustivel,
        @JsonAlias("MesReferencia") String mesReferencia
) {}
