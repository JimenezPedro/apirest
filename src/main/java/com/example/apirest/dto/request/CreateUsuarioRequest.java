package com.example.apirest.dto.request;

import lombok.Data;

@Data
public class CreateUsuarioRequest {
    //añadir  jakarta.validation.constraints.NotBlank
    private String nombre;
    private String email;
    private String password;

}
