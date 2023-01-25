package com.example.testy.dao;

import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoDao extends JpaRepository<Producto,Long> {

    public List<Producto> findAllByPuntoDeVentaProducto(PuntoDeVentaProducto puntoDeVentaProducto);


}
