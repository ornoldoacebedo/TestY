package com.example.testy.service;

import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVenta;

import java.util.List;

public interface IProductoService{

    public Producto createProduct(Producto product);

    public Producto updateProduct(Producto product);

    public List<Producto> lis();

    //public Producto findProductByCompany(Long id);
    public List<Producto> findProductByPointID(List<PuntoDeVenta> puntosDeVenta);

    public Producto findProductID(Long id);






}
