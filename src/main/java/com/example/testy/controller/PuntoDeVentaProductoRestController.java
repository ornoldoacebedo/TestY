package com.example.testy.controller;
import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVenta;
import com.example.testy.entity.PuntoDeVentaProducto;
import com.example.testy.mapper.Mapper;
import com.example.testy.model.MProducto;
import com.example.testy.model.MPuntoDeVentaProducto;
import com.example.testy.service.IProductoService;
import com.example.testy.service.IPuntoDeVentaProductoService;
import com.example.testy.service.IPuntoDeVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class PuntoDeVentaProductoRestController {

    @Autowired
    private IPuntoDeVentaService pointService;
    @Autowired
    private IProductoService productService;

    @Autowired
    private IPuntoDeVentaProductoService puntVProd;


    @GetMapping("/listr")
    private ResponseEntity<List<PuntoDeVentaProducto>> listRelacion(){
    System.out.println(puntVProd.lisRelacion());
        return new ResponseEntity<>(puntVProd.lisRelacion(),HttpStatus.OK);
    }

    @GetMapping("/listrr")
    private ResponseEntity<List<MPuntoDeVentaProducto>> lisstRelacion(){
        System.out.println(puntVProd.lisRelacion());
        List<MPuntoDeVentaProducto> mproductos = new ArrayList<>();
        mproductos = puntVProd.lisRelacion().stream().map(MPuntoDeVentaProducto ::new).collect(Collectors.toList());
        //mproductos = Mapper.convertirLista2(puntVProd.lisRelacion());

        return new ResponseEntity<List<MPuntoDeVentaProducto>>(mproductos,HttpStatus.OK);
    }
    /*
        @GetMapping("/lis/{id}")
    private ResponseEntity<List<Producto>> listProductsByCompany(@PathVariable(name = "id") Long id){
        //obtengo los puntos de venta por el id de company
        List<PuntoDeVenta> listapv = pointService.findByCompany(id);
        List<Producto> listaprod= new ArrayList<>();
        for (PuntoDeVenta cadena:listapv) {
            listaprod.addAll(productService.findProductByPointID(cadena.getId()));
        }
        return new ResponseEntity<List<Producto>>(listaprod, HttpStatus.OK);
    }
     */
    @GetMapping("/lis/{id}")
    private ResponseEntity<List<MProducto>> listProductsByCompany(@PathVariable(name = "id") Long id){
        //obtengo los puntos de venta por el id de company
        List<PuntoDeVenta> listapv = pointService.findByCompany(id);
        List<MProducto> mproductos = new ArrayList<>();
       // mproductos = Mapper.convertirLista(productService.findProductByPointID(listapv));

        mproductos = productService.findProductByPointID(listapv).stream().map(MProducto::new).collect(Collectors.toList());

        return new ResponseEntity<List<MProducto>>(mproductos, HttpStatus.OK);
    }



    /*
    @GetMapping("/lis/{id}")
    private ResponseEntity<List<Producto>> listProductsByCompany(@PathVariable(name = "id") Long id){
        //obtengo los puntos de venta por el id de company
        List<PuntoDeVenta> listapv = pointService.findByCompany(id);
        //List<Producto> listaprod= productService.findProductByPointID(listapv);

        return new ResponseEntity<List<Producto>>(productService.findProductByPointID(listapv), HttpStatus.OK);
    }

     */
    @PostMapping("/addpvp")
    public ResponseEntity<?> addProductoPuntoDeVenta(@RequestBody PuntoDeVentaProducto puntoVProducto){

        puntoVProducto.setProducto(productService.findProductID(puntoVProducto.getId().getProductoId()));
        puntoVProducto.setPuntoDeVenta(pointService.findPointSaleID(puntoVProducto.getId().getPuntoDeVentaId()));
        System.out.println("Lo que llega por post"+puntoVProducto);
        puntVProd.addPuntoDeVentaProducto(puntoVProducto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
