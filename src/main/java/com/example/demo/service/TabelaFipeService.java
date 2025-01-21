package com.example.demo.service;

import com.example.demo.model.Dados;
import com.example.demo.model.Modelos;
import com.example.demo.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabelaFipeService {
    @Autowired
    private ConsumoApi consumoApi;
    @Autowired
    private ConverteDados converteDados;
    @Value("${url.adress.secret}")
    private String endereco;
    private List<Dados> lista;
    private String codigoMarca;
    private Modelos listaModelos;
    private String codigoVeiculo;
    private List<Dados> especificacoes;
    private String codigoEspecificacao;

    public List<Dados> obterMarcas(){
        String json=consumoApi.obterDados(endereco);
        lista= Arrays.asList(converteDados.obterDados(json,Dados[].class));
        return lista;
    }
    public Modelos obterVeiculos(String marca){
        List<Dados> busca=lista.stream().filter(l->l.nome().contains(marca)).collect(Collectors.toList());
        codigoMarca=busca.get(0).codigo();
        String json=consumoApi.obterDados(endereco+busca.get(0).codigo()+"/modelos");
        listaModelos=converteDados.obterDados(json,Modelos.class);
        return listaModelos;
    }
    public List<Dados> obterEspecificacoes(String veiculo){
        var busca=listaModelos.modelos().stream().filter(l->l.nome().contains(veiculo)).collect(Collectors.toList());
        codigoVeiculo=busca.get(0).codigo();
        String json=consumoApi.obterDados(endereco+codigoMarca+"/modelos/"+codigoVeiculo+"/anos");
        especificacoes=Arrays.asList(converteDados.obterDados(json,Dados[].class));
        return especificacoes;
    }

    public Veiculo obterEspecificacaoCompleta(String especificacao){
        var busca=especificacoes.stream().filter(l->l.nome().contains(especificacao)).collect(Collectors.toList());
        codigoEspecificacao=busca.get(0).codigo();
        String json=consumoApi.obterDados(endereco+codigoMarca+"/modelos/"+codigoVeiculo+"/anos/"+codigoEspecificacao);
        var veiculo=converteDados.obterDados(json, Veiculo.class);
        return veiculo;
    }
}

