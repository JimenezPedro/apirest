package com.example.apirest.controller;

import com.example.apirest.entity.Tarea;
import com.example.apirest.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @GetMapping
    public List<Tarea> findAll() {
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarea> findById(@PathVariable Long id) {
        return tareaService.findById(id);
    }

    @PostMapping
    public Tarea addTarea(@RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }

    @PostMapping("/{id}")
    public void deleteTarea(@PathVariable Long id) {
        tareaService.delete(id);
    }

}
