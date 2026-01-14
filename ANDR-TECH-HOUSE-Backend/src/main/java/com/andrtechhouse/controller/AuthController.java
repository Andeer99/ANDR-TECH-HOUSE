package com.andrtechhouse.controller;

import com.andrtechhouse.dto.auth.AuthResponse;
import com.andrtechhouse.dto.auth.LoginRequest;
import com.andrtechhouse.dto.auth.RefreshRequest;
import com.andrtechhouse.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    /* ---------- Login ---------- */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return service.authenticate(request);
    }

    /* ---------- Refresh ---------- */
    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse refresh(@Valid @RequestBody RefreshRequest request) {
        return service.refreshToken(request);
    }
}
