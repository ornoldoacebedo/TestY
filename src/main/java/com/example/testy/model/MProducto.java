package com.example.testy.model;

import com.example.testy.entity.Producto;
import lombok.Data;

@Data
public class MProducto {
    private String name;

    private Long trademark;

    private Long provider;

    private Long unit;


    public MProducto(Producto producto){
        this.name= producto.getName();
        this.trademark=producto.getTrademark();
        this.provider=producto.getProvider();
        this.unit=producto.getUnit();
    }

}
