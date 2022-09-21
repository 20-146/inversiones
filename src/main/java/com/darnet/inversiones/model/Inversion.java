package com.darnet.inversiones.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Inversion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer cantidad;
    private Moneda moneda;
    private LocalDate fecha;
    private Categoria categoria;
    private double gastosIncluidos;
    private String observaciones;
}
