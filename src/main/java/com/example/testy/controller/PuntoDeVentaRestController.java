package com.example.testy.controller;
import com.example.testy.entity.PuntoDeVenta;
import com.example.testy.service.IPuntoDeVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PuntoDeVentaRestController {
    @Autowired
    private IPuntoDeVentaService pointSaleService;

    @PostMapping("/addpv")
    public ResponseEntity<?> addPointSale(@RequestBody PuntoDeVenta pointSale){
        pointSaleService.createPointSale(pointSale);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/updpv/{id}")
    public ResponseEntity<?> updatePointSale(@PathVariable(value = "id")Long id, @RequestBody PuntoDeVenta pointSale){
        PuntoDeVenta puntoVenta = pointSaleService.findPointSaleID(id);
        if (puntoVenta!=null){
            puntoVenta.setName(pointSale.getName());
            pointSaleService.updatePointSale(puntoVenta);
            return new ResponseEntity<>(puntoVenta,HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listpv")
    public ResponseEntity<List<PuntoDeVenta>> listPointsSales(){
        return new ResponseEntity<>(pointSaleService.lis(),HttpStatus.OK);
    }

    @GetMapping("/listpvc/{id}")
    public ResponseEntity<List<PuntoDeVenta>> listPointsSalesByCompany(@PathVariable(value = "id")Long id){
        List<PuntoDeVenta> lista = pointSaleService.findByCompany(id);
        System.out.println("LISTA DE PUNTOS DE VENTAS"+lista);
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

}
