package com.example.testy.service;

import com.example.testy.entity.Empresa;
import com.example.testy.entity.PuntoDeVenta;

import java.util.List;

public interface IPuntoDeVentaService {

    public PuntoDeVenta findPointSaleID(Long id);

    public PuntoDeVenta updatePointSale(PuntoDeVenta pointsale);

    public PuntoDeVenta createPointSale(PuntoDeVenta pointsale);

    public List<PuntoDeVenta> lis();

    public List<PuntoDeVenta> findByCompany(long id);
}
