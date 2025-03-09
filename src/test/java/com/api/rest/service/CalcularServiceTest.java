package com.api.rest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalcularServiceTest {

    @Mock
    private ExternalService externalService;

    @InjectMocks
    private CalcularService calculationService;

    @Test
    void testCalcularXPorcentaje() {
        // Simular que el servicio externo devuelve un porcentaje del 10%
        when(externalService.getPorcentaje()).thenReturn(10.0);

        double result = calculationService.calcularXPorcentaje(100, 50);

        // 100 + 50 = 150, luego 150 + 10% de 150 = 165
        assertEquals(165.0, result);
    }

}
