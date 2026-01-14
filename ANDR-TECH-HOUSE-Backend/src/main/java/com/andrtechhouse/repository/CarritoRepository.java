package com.andrtechhouse.repository;

import com.andrtechhouse.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByUsuarioEmail(String email);
}
