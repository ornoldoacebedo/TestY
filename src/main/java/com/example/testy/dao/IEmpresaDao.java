package com.example.testy.dao;

import com.example.testy.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaDao extends JpaRepository<Empresa, Long> {
    public Empresa findEmpresasById(long id);

}
