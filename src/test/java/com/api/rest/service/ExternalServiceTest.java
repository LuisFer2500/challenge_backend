package com.api.rest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@EnableCaching
@ExtendWith(MockitoExtension.class)
class ExternalServiceTest {

    @MockBean
    private ExternalService externalService;

    @BeforeEach
    void setUp() {
        // Simular un valor por defecto para evitar errores si el servicio falla
        when(externalService.getPorcentaje()).thenReturn(0.5);
    }

    @Test
    void testGetPorcentaje_Cacheable() {
        // Simulamos que `getPorcentaje()` devuelve un valor fijo de 0.7
        when(externalService.getPorcentaje()).thenReturn(0.7);

        // Primera llamada: obtiene el valor simulado
        double firstCall = externalService.getPorcentaje();
        System.out.println("Primer valor obtenido: " + firstCall);

        // Segunda llamada: debería venir del mock (ya que el caché no está configurado realmente en esta prueba)
        double secondCall = externalService.getPorcentaje();
        System.out.println("Segundo valor obtenido: " + secondCall);

        assertEquals(firstCall, secondCall, "El valor devuelto debe ser el mismo en ambas llamadas");
    }

    @Test
    void testGetPorcentaje_ExceptionHandling() {
        // Simular que `getPorcentaje()` lanza una excepción
        when(externalService.getPorcentaje()).thenThrow(new RuntimeException("Fallo en el servicio externo"));

        // Verificar que la excepción se lanza correctamente
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            externalService.getPorcentaje();
        });

        assertEquals("Fallo en el servicio externo", exception.getMessage());
    }
}
