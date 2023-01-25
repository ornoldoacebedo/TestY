package com.example.testy.service;

import com.example.testy.dao.IPuntoDeVentaDao;
import com.example.testy.entity.PuntoDeVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoDeVentaServiceImp  implements IPuntoDeVentaService{

    @Autowired
    private IPuntoDeVentaDao pointSaleDao;

    @Override
    public PuntoDeVenta findPointSaleID(Long id) {
        return pointSaleDao.findById(id).orElse(null);
    }

    @Override
    public PuntoDeVenta updatePointSale(PuntoDeVenta pointsale) {
        return pointSaleDao.save(pointsale);
    }

    @Override
    public PuntoDeVenta createPointSale(PuntoDeVenta pointsale) {
        return pointSaleDao.save(pointsale);
    }

    @Override
    public List<PuntoDeVenta> lis() {
        return (List<PuntoDeVenta>) pointSaleDao.findAll();
    }

    @Override
    public List<PuntoDeVenta> findByCompany(long id) {
       return pointSaleDao.findAllByCompany(id);
    }

}
