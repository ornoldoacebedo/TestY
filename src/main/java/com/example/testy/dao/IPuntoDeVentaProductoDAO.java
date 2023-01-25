package com.example.testy.dao;


import com.example.testy.entity.PuntoDeVentaProducto;
import com.example.testy.entity.PuntoDeVentaProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPuntoDeVentaProductoDAO extends JpaRepository<PuntoDeVentaProducto, PuntoDeVentaProductoId> {
    public List<PuntoDeVentaProducto> findPuntoDeVentaProductoByPuntoDeVentaId(Long id);


}
