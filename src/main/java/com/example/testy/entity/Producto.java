package com.example.testy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.*;


@Entity
@Data
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "code",unique = true,nullable = false)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "costPrice",nullable = false)
    private float costPrice;

    @Column(name = "salePrice",nullable = false)
    private float salePrice;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name = "modification_Date", nullable = false)
    private Date modificationDate;

    @PrePersist
    public void prePersist() {
        creationDate = new Date();
    }
    @Column(name = "trademarkID")
    private Long trademark;
    @Column(name = "providerID")
    private Long provider;
    @Column(name = "unitID")
    private Long unit;
  //  @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "producto")
    //@JsonIgnore
    private Set<PuntoDeVentaProducto> puntoDeVentaProducto = new HashSet<PuntoDeVentaProducto>(0);
}
