package com.example.testy.service;

import com.example.testy.dao.IPuntoDeVentaProductoDAO;
import com.example.testy.entity.PuntoDeVentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoDeVentaProductoServiceImpl implements IPuntoDeVentaProductoService{

    @Autowired
    private IPuntoDeVentaProductoDAO puntoDeVProd;

    @Override
    public PuntoDeVentaProducto addPuntoDeVentaProducto(PuntoDeVentaProducto pointSaleProduct) {
        return puntoDeVProd.save(pointSaleProduct);
    }

    @Override
    public List<PuntoDeVentaProducto> lisRelacion() {

        return (List<PuntoDeVentaProducto>) puntoDeVProd.findAll();
    }
}
