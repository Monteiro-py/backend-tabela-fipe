package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
