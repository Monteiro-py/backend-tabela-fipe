package com.example.demo.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todas as rotas
                .allowedOrigins("https://project-tabela-fipe-woad-two.vercel.app", "https://project-tabela-fipe-woad-two.vercel.app/filtro", "http://localhost:4200") // Permite esses domínios
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true);
    }

}
