package com.example.testy.dao;

import com.example.testy.entity.UnidadDeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnidadDeMedidaDao extends JpaRepository<UnidadDeMedida,Long> {
}
