package com.example.testy.controller;

import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVentaProducto;
import com.example.testy.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductoRestController {
    @Autowired
    private IProductoService productService;
    @PostMapping("/addpr")
    private ResponseEntity<?> addProduct(@RequestBody Producto product){
        productService.createProduct(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @GetMapping("/lispr")
    private ResponseEntity<List<Producto>> listProduct(){
        return new ResponseEntity<>(productService.lis(),HttpStatus.OK);
    }
    /*
    @GetMapping("/lisprpv/{id}")
    private ResponseEntity<List<Producto>> listProductByCompany(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(productService.findProductByPointID(id),HttpStatus.OK);
    }

     */


/*
    @GetMapping("/lispr/{id}")
    private ResponseEntity<List<Producto>> listProduct(@PathVariable(value = "id")Long id){
        return new ResponseEntity<>(productService.findProductoBy(id),HttpStatus.OK);
    }

 */



}
