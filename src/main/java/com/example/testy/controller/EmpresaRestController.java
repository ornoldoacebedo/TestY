package com.example.testy.controller;

import com.example.testy.entity.Empresa;
import com.example.testy.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/company")
public class EmpresaRestController {
    @Autowired
    private IEmpresaService companyService;

    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody Empresa company) {
        companyService.createCompany(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<?> updateCompany(@PathVariable(value = "id") Long id, @RequestBody Empresa company,
                                           @RequestParam(required = false) String nombre) {
        Empresa empresa = companyService.findCompanyID(id);
        if (empresa != null) {
            empresa.setName(company.getName());
            companyService.updateCompany(empresa);
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listCompany() {
        System.out.println("Esto es una mierda");
        System.out.println(companyService.lis());
        return new ResponseEntity<>(companyService.lis(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> listCompany(@PathVariable(value = "id") Long id) {
        System.out.println("Valor de companyService.findCompanyID(id)"+companyService.findCompanyID(id));
        return new ResponseEntity<>(companyService.findCompanyID(id), HttpStatus.OK);
    }

}
