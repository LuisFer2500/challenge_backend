package com.api.rest.controller;

import com.api.rest.service.CalcularService;
import com.api.rest.service.HistorialLlamadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api")
@Tag(name = "Cálculo", description = "Operaciones de cálculo con porcentaje dinámico")
public class CalcularController {
    @Autowired
    private CalcularService calcularService;

    @Autowired
    private HistorialLlamadaService historialLlamadaService;

    @Operation(summary = "Calcula la suma con un porcentaje dinámico", description = "Recibe num1 y num2, los suma y aplica un porcentaje adicional obtenido de un servicio externo o caché.")
    @ApiResponse(responseCode = "200", description = "Cálculo realizado con éxito")
    @ApiResponse(responseCode = "500", description = "Error interno en la API")
    @GetMapping("/calcular")
    public ResponseEntity<Double> calcular(@RequestParam double num1, @RequestParam double num2){
        double resultado = calcularService.calcularXPorcentaje(num1, num2);

        historialLlamadaService.saveLlamada("/api/calcular", "num1=" + num1 + ", num2=" + num2, "Resultado: " + resultado);

        return ResponseEntity.ok(resultado);
    }
}
