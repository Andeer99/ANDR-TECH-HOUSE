package com.andrtechhouse.repository;

import com.andrtechhouse.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Para processCallback(...)
    Optional<Pago> findByPasarelaId(String pasarelaId);
}
