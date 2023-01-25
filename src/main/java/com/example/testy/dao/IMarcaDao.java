package com.example.testy.dao;

import com.example.testy.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaDao extends JpaRepository<Marca, Long> {

}
