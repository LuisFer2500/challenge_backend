package com.api.rest.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "porcentajeCache")
public class ExternalService {
    private Double porcentajeFinal = null;

    @Cacheable("porcentajeCache")
    public double getPorcentaje() {
        try {
            System.out.println("Obteniendo porcentaje del servicio externo...");
            double nuevoPorcentaje = obtenerPorcentajeExterno();
            porcentajeFinal = nuevoPorcentaje;  // Guardar el último valor válido
            return nuevoPorcentaje;
        } catch (Exception e) {
            System.out.println("Error al obtener el porcentaje. Usando último valor en caché...");

            if (porcentajeFinal != null) {
                return porcentajeFinal; // Usar el último valor almacenado
            } else {
                throw new RuntimeException("No se pudo obtener el porcentaje y no hay valores almacenados.");
            }
        }
    }

    private double obtenerPorcentajeExterno() {
        if (Math.random() < 0.1) { // 10% de probabilidad de fallo
            throw new RuntimeException("Fallo en el servicio externo");
        }
        return Math.random(); // Retorna un porcentaje entre 0.0 y 1.0
    }


}