package com.example.testy.service;

import com.example.testy.entity.Proveedor;
import com.example.testy.entity.UnidadDeMedida;

import java.util.List;

public interface IUnidadDeMedidaService {
    public UnidadDeMedida findUnitID(Long id);

    public UnidadDeMedida updateUnit(UnidadDeMedida unit);

    public UnidadDeMedida createUnit(UnidadDeMedida unit);

    public List<UnidadDeMedida> lis();
}
