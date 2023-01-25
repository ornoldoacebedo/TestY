package com.example.testy.controller;

import com.example.testy.entity.Inventario;
import com.example.testy.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class InventarioRestController {
    @Autowired
    private IInventarioService inventoryService;
/*
    public ResponseEntity<?> agregarProductoAPuntoDeVenta(@PathVariable(value = "id")Long id, @RequestBody Inventario inventario){
        inventoryService.findInventoryById(id);

    }

 */



    @GetMapping("/lisi")
    public ResponseEntity<List<Inventario>> listInventory(){
        return new ResponseEntity<>(inventoryService.listInventory(), HttpStatus.OK);
    }


}
