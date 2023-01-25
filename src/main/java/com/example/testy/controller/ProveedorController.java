package com.example.testy.controller;

import com.example.testy.entity.Marca;
import com.example.testy.entity.Proveedor;
import com.example.testy.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private IProveedorService providerService;
    @PostMapping("/addp")
    public ResponseEntity<?> addProvider(@RequestBody Proveedor provider){
        providerService.createProvider(provider);
        return new ResponseEntity<Void>(HttpStatus.OK);


       // provider = providerService.createProvider(provider);
       // return new ResponseEntity<>(provider, HttpStatus.OK);
    }
    @PostMapping("/updp/{id}")
    public ResponseEntity<?> updateProvider(@PathVariable(value="id")Long id, @RequestBody Proveedor provider){
        Proveedor proveedor = providerService.findProviderID(id);
        System.out.println("proveedor");
        System.out.println(proveedor);
        System.out.println("provider");
        System.out.println(provider);
        proveedor.setName(provider.getName());
        providerService.updateProvider(proveedor);
        return new ResponseEntity<>(proveedor,HttpStatus.OK);
    }
    @GetMapping("listp")
    public ResponseEntity<List<Proveedor>> listProvider(){
        return new ResponseEntity<>(providerService.lis(),HttpStatus.OK);
    }



}
