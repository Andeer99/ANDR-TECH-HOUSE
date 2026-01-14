package com.andrtechhouse.mapper;

import com.andrtechhouse.dto.pago.PagoDTO;
import com.andrtechhouse.model.Pago;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * MapStruct mapper para convertir Pago ↔ PagoDTO
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface PagoMapper {

    /**
     * Mapea una entidad Pago a su DTO
     */
    PagoDTO toDto(Pago pago);
    List<PagoDTO> toDtoList(List<Pago> pagos);

}
