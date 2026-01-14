package com.andrtechhouse.dto.auth;

/** Petición de login */
public record LoginRequest(String email, String password) {}