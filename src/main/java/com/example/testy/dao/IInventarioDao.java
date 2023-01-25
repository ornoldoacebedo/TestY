package com.example.testy.dao;

import com.example.testy.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioDao extends JpaRepository<Inventario,Long> {





}
