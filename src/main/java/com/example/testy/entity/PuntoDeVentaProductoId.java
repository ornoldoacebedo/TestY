package com.example.testy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class PuntoDeVentaProductoId implements Serializable {
    @Column(name = "product_id")
    private Long productoId;
    @Column(name = "pont_sale_id")
    private Long puntoDeVentaId;
}
