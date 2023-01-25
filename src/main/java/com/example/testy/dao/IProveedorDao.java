package com.example.testy.dao;

import com.example.testy.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorDao extends JpaRepository<Proveedor,Long> {
}
