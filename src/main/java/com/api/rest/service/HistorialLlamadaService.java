package com.api.rest.service;

import com.api.rest.entity.HistorialLlamada;
import com.api.rest.repository.HistorialLlamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistorialLlamadaService {

    @Autowired
    private HistorialLlamadaRepository historialLlamadaRepository;

    //Para registrar el historial
    @Async
    public void saveLlamada(String endpoint, String parameters, String response){
        HistorialLlamada historial = new HistorialLlamada();

        historial.setEndpoint(endpoint);
        historial.setResponse(response);
        historial.setParameters(parameters);
        historial.setTimestamp(LocalDateTime.now());

        historialLlamadaRepository.save(historial);

    }

    public Page<HistorialLlamada> getAllHistarialLlamada(Pageable pageable){
        return historialLlamadaRepository.findAll(pageable);
    }

}
