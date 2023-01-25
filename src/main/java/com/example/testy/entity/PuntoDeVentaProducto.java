package com.example.testy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class PuntoDeVentaProducto implements Serializable {

    @EmbeddedId
    private PuntoDeVentaProductoId id;
   // @JsonBackReference("IDproducto")
    @MapsId("productoId")
    @ManyToOne
    //(fetch=FetchType.LAZY)
    private Producto producto;
    //@JsonBackReference("IDpuntoDeVenta")
    @MapsId("puntoDeVentaId")
    @ManyToOne
    //(fetch=FetchType.LAZY)
    private PuntoDeVenta puntoDeVenta;
    @Column(nullable = false)
    private Float amount;

}
