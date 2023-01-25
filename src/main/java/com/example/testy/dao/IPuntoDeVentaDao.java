package com.example.testy.dao;

import com.example.testy.entity.PuntoDeVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPuntoDeVentaDao extends JpaRepository<PuntoDeVenta,Long> {
    public List<PuntoDeVenta> findAllByCompany(long id);

}
