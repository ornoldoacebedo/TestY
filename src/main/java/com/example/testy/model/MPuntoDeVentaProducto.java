package com.example.testy.model;

import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVenta;
import com.example.testy.entity.PuntoDeVentaProducto;
import lombok.Data;


@Data
public class MPuntoDeVentaProducto {

    private String nameproduct;

    private String namepointSale;
    private float amount;

    public MPuntoDeVentaProducto(PuntoDeVentaProducto puntoDeVentaProducto){
        this.nameproduct = puntoDeVentaProducto.getProducto().getName();
        this.namepointSale=puntoDeVentaProducto.getPuntoDeVenta().getName();
        this.amount= puntoDeVentaProducto.getAmount();
      }


}
