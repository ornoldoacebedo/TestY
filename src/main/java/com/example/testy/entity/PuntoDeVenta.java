package com.example.testy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class PuntoDeVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name",nullable = false)
    private String name;


    @Column(name = "companyID")
    private Long company;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name = "modification_Date", nullable = false)
    private Date modificationDate;

  //  @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "puntoDeVenta")
  //  @JsonIgnore
    private Set<PuntoDeVentaProducto> puntoDeVentaProducto=new HashSet<PuntoDeVentaProducto>(0);

}
