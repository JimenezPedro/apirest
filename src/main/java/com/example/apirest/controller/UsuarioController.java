package com.example.apirest.controller;

import com.example.apirest.entity.Tarea;
import com.example.apirest.entity.Usuario;
import com.example.apirest.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PostMapping("/{id}/asignarTarea")
    public ResponseEntity<Tarea> asignarTareas(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea tareaAsignada = usuarioService.asignarTarea(id, tarea);
        return ResponseEntity.ok(tareaAsignada);
    }

}
