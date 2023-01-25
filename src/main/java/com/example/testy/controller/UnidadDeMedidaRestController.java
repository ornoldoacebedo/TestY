package com.example.testy.controller;

import com.example.testy.entity.Empresa;
import com.example.testy.entity.UnidadDeMedida;
import com.example.testy.service.IUnidadDeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UnidadDeMedidaRestController {
    @Autowired
    private IUnidadDeMedidaService unitService;

    @PostMapping("/addu")
    public ResponseEntity<?> addUnit(@RequestBody UnidadDeMedida unit){
        unitService.createUnit(unit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/updu/{id}")
    public ResponseEntity<?> updateUnit(@PathVariable(value = "id")Long id, @RequestBody UnidadDeMedida unit){
        UnidadDeMedida unidad = unitService.findUnitID(id);
        if (unidad!=null){
            unidad.setDescription(unit.getDescription());
            return new ResponseEntity<>(unidad,HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listu")
    public ResponseEntity<List<UnidadDeMedida>> listUnidades(){
        return new ResponseEntity<>(unitService.lis(),HttpStatus.OK);
    }
}
