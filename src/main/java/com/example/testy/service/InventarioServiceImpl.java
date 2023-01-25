package com.example.testy.service;

import com.example.testy.dao.IInventarioDao;
import com.example.testy.entity.Inventario;
import com.example.testy.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements IInventarioService{

    @Autowired
    private IInventarioDao inventoryDao;
    @Override
    public List<Inventario> listInventory() {
        return (List<Inventario>) inventoryDao.findAll();
    }

    @Override
    public Inventario findInventoryById(Long id) {
        return inventoryDao.findById(id).orElse(null);
    }
}
