package com.example.apirest.service;

import com.example.apirest.entity.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}


