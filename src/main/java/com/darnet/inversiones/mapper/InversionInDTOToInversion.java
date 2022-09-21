package com.darnet.inversiones.mapper;

import com.darnet.inversiones.model.Categoria;
import com.darnet.inversiones.model.Inversion;
import com.darnet.inversiones.services.InversionService;
import com.darnet.inversiones.services.dto.InversionInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InversionInDTOToInversion implements IMapper<InversionInDTO, Inversion> {
    @Override
    public Inversion map(InversionInDTO in) {
        Inversion inversion = new Inversion();
        inversion.setCantidad(in.getCantidad());
        inversion.setMoneda(in.getMoneda());
        inversion.setFecha(LocalDate.now());
        inversion.setGastosIncluidos(in.getGastosIncluidos());
        inversion.setCategoria(in.getCategoria());
        inversion.setObservaciones(in.getObservaciones());
        return inversion;
    }
    public Inversion mapUpdate(Inversion in, Inversion out){
        out.setCantidad(in.getCantidad());
        out.setFecha(LocalDate.now());
        out.setGastosIncluidos(in.getGastosIncluidos());
        out.setCategoria(in.getCategoria());
        out.setObservaciones(in.getObservaciones());
        return out;
    }
}
