package com.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalcularService {

    @Autowired
    private ExternalService externalService;

    public double calcularXPorcentaje(double num1, double num2){
        double porcentaje = externalService.getPorcentaje();
        double suma = num1 + num2;
        return suma + (suma * porcentaje / 100);

    }
}
