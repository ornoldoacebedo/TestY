package com.example.testy.service;

import com.example.testy.dao.IEmpresaDao;
import com.example.testy.entity.Empresa;
import com.example.testy.entity.UnidadDeMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService{
    @Autowired
    private IEmpresaDao companyDao;

    @Override
    public Empresa findCompanyID(Long id) {
        //return companyDao.findById(id).orElse(null);
        return (Empresa) companyDao.findEmpresasById(id);
    }

    @Override
    public Empresa updateCompany(Empresa company) {
        return companyDao.save(company);
    }
    @Override
    public Empresa createCompany(Empresa company) {

        return companyDao.save(company);
    }

    @Override
    public List<Empresa> lis() {
        return (List<Empresa>) companyDao.findAll();
    }

}
