package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apirest.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
