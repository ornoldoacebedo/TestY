package com.example.testy.service;

import com.example.testy.entity.Inventario;
import com.example.testy.entity.Marca;

import java.util.List;

public interface IInventarioService {
    public List<Inventario> listInventory();

    public Inventario findInventoryById(Long id);
}
