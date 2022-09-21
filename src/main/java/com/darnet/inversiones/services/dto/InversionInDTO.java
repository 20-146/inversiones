package com.darnet.inversiones.services.dto;

import com.darnet.inversiones.model.Categoria;
import com.darnet.inversiones.model.Moneda;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InversionInDTO {
    private Integer cantidad;
    private Moneda moneda;
    private Categoria categoria;
    private double gastosIncluidos;
    private String observaciones;
}
