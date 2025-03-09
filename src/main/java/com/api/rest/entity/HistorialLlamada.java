package com.api.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "callhistorial")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistorialLlamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private String endpoint;
    private String parameters;
    private String response;

}
