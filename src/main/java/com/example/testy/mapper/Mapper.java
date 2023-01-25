package com.example.testy.mapper;

import com.example.testy.entity.Producto;
import com.example.testy.entity.PuntoDeVentaProducto;
import com.example.testy.model.MProducto;
import com.example.testy.model.MPuntoDeVentaProducto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mappeer")
public class Mapper {
    public static List<MProducto> convertirLista(List<Producto> productos){
        List<MProducto> mproductos =new ArrayList<>();
        for (Producto producto:productos) {
            mproductos.add(new MProducto(producto));
        }
        return mproductos;
    }
    public static List<MPuntoDeVentaProducto> convertirLista2(List<PuntoDeVentaProducto> mproductosPuntodeVenta){
        List<MPuntoDeVentaProducto> mproductPuntodeVenta =new ArrayList<>();
        for (PuntoDeVentaProducto productosPuntodeVenta:mproductosPuntodeVenta) {
            mproductPuntodeVenta.add(new MPuntoDeVentaProducto(productosPuntodeVenta));
        }
        return mproductPuntodeVenta;
    }
}
