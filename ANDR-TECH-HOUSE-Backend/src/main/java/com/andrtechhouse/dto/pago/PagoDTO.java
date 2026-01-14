package com.andrtechhouse.dto.pago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagoDTO(
        Long id,
        BigDecimal monto,
        String estado,
        String pasarelaId,
        LocalDateTime fecha
) {}
