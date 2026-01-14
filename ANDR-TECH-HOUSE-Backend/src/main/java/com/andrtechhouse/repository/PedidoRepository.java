package com.andrtechhouse.repository;

import com.andrtechhouse.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Para initPayment / createOrder:
    Optional<Pedido> findByIdAndUsuarioEmail(Long id, String usuarioEmail);

    // Para listar pedidos de un cliente:
    List<Pedido> findByUsuarioEmailOrderByFechaDesc(String usuarioEmail);
}
