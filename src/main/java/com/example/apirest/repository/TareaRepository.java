package com.example.apirest.repository;

import com.example.apirest.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    Optional<Tarea> findByNombre(String nombre);
    Boolean existsByNombre(String nombre);
}
