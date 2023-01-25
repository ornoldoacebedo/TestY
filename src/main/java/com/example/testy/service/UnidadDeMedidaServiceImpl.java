package com.example.testy.service;

import com.example.testy.dao.IUnidadDeMedidaDao;
import com.example.testy.entity.Proveedor;
import com.example.testy.entity.UnidadDeMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadDeMedidaServiceImpl implements IUnidadDeMedidaService{

    @Autowired
    private IUnidadDeMedidaDao unitDao;


    @Override
    public UnidadDeMedida findUnitID(Long id) {
        return (UnidadDeMedida) unitDao.findById(id).orElse(null);
    }

    @Override
    public UnidadDeMedida updateUnit(UnidadDeMedida unit) {
        return (UnidadDeMedida) unitDao.save(unit);
    }
    @Override
    public UnidadDeMedida createUnit(UnidadDeMedida unit) {
        return (UnidadDeMedida) unitDao.save(unit);
    }

    @Override
    public List<UnidadDeMedida> lis() {
        return (List<UnidadDeMedida>) unitDao.findAll();
    }
}
