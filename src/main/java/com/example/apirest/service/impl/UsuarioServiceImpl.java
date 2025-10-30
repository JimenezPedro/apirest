package com.example.apirest.service.impl;

import com.example.apirest.entity.Tarea;
import com.example.apirest.entity.Usuario;
import com.example.apirest.repository.TareaRepository;
import com.example.apirest.repository.UsuarioRepository;
import com.example.apirest.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TareaRepository tareaRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Tarea asignarTarea(Long usuarioId, Tarea tarea) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if(usuarioOpt.isEmpty()){
            throw new RuntimeException("Usuario no encontrado con id: "  + usuarioId);
        }
        Usuario usuario = usuarioOpt.get();
        tarea.setUsuario(usuario);
        Tarea tareaGuardada = tareaRepository.save(tarea);
        usuario.getTareas().add(tareaGuardada);

        return tareaGuardada;
    }

}
