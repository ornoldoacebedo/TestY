package com.example.testy.service;

import com.example.testy.entity.Marca;
import com.example.testy.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProveedorService {

    public Proveedor findProviderID(Long id);

    public Proveedor updateProvider(Proveedor provider);

    public Proveedor createProvider(Proveedor provider);

    public List<Proveedor> lis();
}
