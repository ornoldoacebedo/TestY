package com.example.testy.service;

import com.example.testy.entity.PuntoDeVentaProducto;

import java.util.List;

public interface IPuntoDeVentaProductoService {
    public PuntoDeVentaProducto addPuntoDeVentaProducto(PuntoDeVentaProducto pointSaleProduct);

    public List<PuntoDeVentaProducto> lisRelacion();



}
