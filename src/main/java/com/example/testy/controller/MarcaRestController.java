package com.example.testy.controller;

import com.example.testy.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.testy.service.IMarcaService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MarcaRestController {

    @Autowired
    private IMarcaService trademarkService;

    @PostMapping("/addm")
    public ResponseEntity<Marca> addtrademark(@RequestBody Marca trademark) {
        trademark = this.trademarkService.save(trademark);
        return new ResponseEntity<>(trademark, HttpStatus.OK);
    }

    @GetMapping("/listm")
    public ResponseEntity<List<Marca>> listarMarcas() {
        return new ResponseEntity<>(trademarkService.listar(), HttpStatus.OK);
    }

    @PostMapping("/updm/{id}")
    public ResponseEntity<?> updateTrademark(@PathVariable(value="id")Long id, @RequestBody Marca trademark) {
        Marca marca = trademarkService.findTradeMarkById(id);
        System.out.println(trademark);
        System.out.println(marca);
        if (marca != null) {
            marca.setName(trademark.getName());
            marca.setDisable(trademark.isDisable());
            System.out.println(trademark.isDisable());
            trademarkService.updateTrademark(marca);
            return new ResponseEntity<>(marca, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dis/{id}")
    public ResponseEntity<?> disableTradeMark(@PathVariable(value="id")Long id, @RequestBody Marca trademark) {
        Marca marca = trademarkService.findTradeMarkById(id);
        if (marca != null) {
            marca.setDisable(trademark.isDisable());
            trademarkService.updateTrademark(marca);
            return new ResponseEntity<>(trademark, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
