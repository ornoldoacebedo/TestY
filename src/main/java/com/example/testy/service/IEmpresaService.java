package com.example.testy.service;

import com.example.testy.entity.Empresa;
import com.example.testy.entity.UnidadDeMedida;

import java.util.List;

public interface IEmpresaService {

    public Empresa findCompanyID(Long id);

    public Empresa updateCompany(Empresa company);

    public Empresa createCompany(Empresa company);

    public List<Empresa> lis();

}
