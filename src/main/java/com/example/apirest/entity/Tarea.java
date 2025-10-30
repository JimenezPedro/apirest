package com.example.apirest.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tareas")
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id") //Clave foránea en la tabla de tareas
    private Usuario usuario;
}