package com.example.apirest.service;


import com.example.apirest.entity.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {
    List<Tarea> findAll();
    Optional<Tarea> findById(Long id);
    Tarea save(Tarea tarea);
    void delete(Long id);
}
