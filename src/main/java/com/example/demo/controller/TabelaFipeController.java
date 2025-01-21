package com.example.demo.controller;

import com.example.demo.model.Dados;
import com.example.demo.model.Modelos;
import com.example.demo.model.Veiculo;
import com.example.demo.service.TabelaFipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/marcas")
public class TabelaFipeController {
    @Autowired
    private TabelaFipeService tabelaFipeService;

    @GetMapping
    public List<Dados> obterMarcas(){
        return tabelaFipeService.obterMarcas();
    }
    @PostMapping("/veiculos")
    public Modelos obterVeiculos(@RequestBody String marca){
        return tabelaFipeService.obterVeiculos(marca);
    }
    @PostMapping("/especificacoes")
    public List<Dados> obterEspecificacoes(@RequestBody String carro){
        return tabelaFipeService.obterEspecificacoes(carro);
    }
    @PostMapping("/especificacaoCompleta")
    public Veiculo obterEspecificacaoCompleta(@RequestBody String especificacao){
        return tabelaFipeService.obterEspecificacaoCompleta(especificacao);
    }
}
