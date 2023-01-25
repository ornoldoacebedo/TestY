package com.example.testy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name",
            unique = true,
            nullable = false)
    private String name;

    @Column(name = "disable")
    private boolean disable;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name = "modification_Date", nullable = false)
    private Date modificationDate;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "trademarkID",referencedColumnName = "id")
    private List<Producto> producList;



}
