package com.api.rest.controller;

import com.api.rest.entity.HistorialLlamada;
import com.api.rest.service.HistorialLlamadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
@Tag(name = "Historial", description = "Manejo del historial de llamadas a la API")
public class HistorialLlamadaController {

    @Autowired
    private HistorialLlamadaService historialLlamadaService;

    @Operation(summary = "Obtiene el historial de llamadas", description = "Devuelve una lista con el historial de llamadas realizadas a la API, incluyendo fecha, endpoint, parámetros y respuesta.")
    @ApiResponse(responseCode = "200", description = "Historial obtenido correctamente")
    @ApiResponse(responseCode = "500", description = "Error interno en la API")
    @GetMapping
    public ResponseEntity<Page<HistorialLlamada>> getAllHistorial(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);

        Page<HistorialLlamada> historial = historialLlamadaService.getAllHistarialLlamada(pageable);

        if(historial.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(historial);
    }



    
}
