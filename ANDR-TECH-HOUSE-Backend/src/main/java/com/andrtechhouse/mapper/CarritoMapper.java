package com.andrtechhouse.mapper;

import com.andrtechhouse.dto.carrito.CarritoDTO;
import com.andrtechhouse.dto.carrito.CarritoItemDTO;
import com.andrtechhouse.model.Carrito;
import com.andrtechhouse.model.CarritoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarritoMapper {

    /* ---- entidad → DTO de carrito ---- */
    @Mappings({
            @Mapping(target = "items", source = "items"),
            @Mapping(target = "total", expression = "java(carrito.getTotal())")
    })
    CarritoDTO toDto(Carrito carrito);

    List<CarritoDTO> toDto(List<Carrito> carritos);

    /* ---- ítem de carrito ---- */
    @Mappings({
            @Mapping(target = "productoId",
                    expression = "java(ci.getProducto()!=null ? ci.getProducto().getId() : null)"),
            @Mapping(target = "nombreProducto",
                    expression = "java(ci.getProducto()!=null ? ci.getProducto().getNombre() : null)"),
            @Mapping(target = "subtotal",
                    expression = "java(ci.getSubtotal())")
    })
    CarritoItemDTO toDto(CarritoItem ci);

    List<CarritoItemDTO> toDtoItems(List<CarritoItem> items);
}
