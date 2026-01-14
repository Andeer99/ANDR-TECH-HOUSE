package com.andrtechhouse.dto.cliente;

public record
ClienteDTO(
        Long   id,
        String nombreCompleto,
        String password,
        String email,
        String rfc
) {}
