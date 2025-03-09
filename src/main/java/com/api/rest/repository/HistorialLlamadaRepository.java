package com.api.rest.repository;

import com.api.rest.entity.HistorialLlamada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HistorialLlamadaRepository extends JpaRepository<HistorialLlamada, Long> {
    Page<HistorialLlamada> findAll(Pageable pageable);
}
