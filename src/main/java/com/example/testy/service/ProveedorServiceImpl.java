package com.example.testy.service;

import com.example.testy.dao.IProveedorDao;
import com.example.testy.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {
    @Autowired
    private IProveedorDao providerDao;

    @Override
    public Proveedor findProviderID(Long id) {
        return providerDao.findById(id).orElse(null);
    }

    @Override
    public Proveedor updateProvider(Proveedor provider) {
        return providerDao.save(provider);
    }

    @Override
    public Proveedor createProvider(Proveedor provider) {
        return providerDao.save(provider);
    }

    @Override
    public List<Proveedor> lis() {
        return (List<Proveedor>) providerDao.findAll();
    }
}
