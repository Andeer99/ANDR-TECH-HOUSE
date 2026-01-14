package com.andrtechhouse.controller;

import com.andrtechhouse.dto.cliente.ClienteCreateDTO;
import com.andrtechhouse.dto.cliente.ClienteResponseDTO;
import com.andrtechhouse.dto.cliente.ClienteUpdateDTO;
import com.andrtechhouse.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return service.findAll();
    }

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO create(@Valid @RequestBody ClienteCreateDTO dto) {
        return service.register(dto);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ClienteUpdateDTO dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
