package com.example.testy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private int stock;
/*
    @OneToMany
    @JoinColumn(name = "inv_prodID",referencedColumnName = "id")
    private List<Producto> producList;

    @OneToMany
    @JoinColumn(name = "inv_pSaleID",referencedColumnName = "id")
    private List<PuntoDeVenta> pointsSales;

 */
}
