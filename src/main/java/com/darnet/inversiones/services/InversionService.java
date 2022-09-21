package com.darnet.inversiones.services;

import com.darnet.inversiones.exceptions.InversionException;
import com.darnet.inversiones.mapper.InversionInDTOToInversion;
import com.darnet.inversiones.model.Categoria;
import com.darnet.inversiones.model.Inversion;
import com.darnet.inversiones.model.Moneda;
import com.darnet.inversiones.repository.InversionRepository;
import com.darnet.inversiones.services.dto.InversionInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InversionService {

    private final InversionRepository inversionRepository;
    private final InversionInDTOToInversion mapper;

    public InversionService(InversionRepository inversionRepository, InversionInDTOToInversion mapper) {
        this.inversionRepository = inversionRepository;
        this.mapper = mapper;
    }

    public Inversion saveInversion(InversionInDTO inversionInDTO) {
        Inversion inversion = mapper.map(inversionInDTO);
        return this.inversionRepository.save(inversion);
    }

    public List<Inversion> listAll() {
        return inversionRepository.findAll();
    }

    public List<Inversion> findbyCategoria(Categoria categoria){
        return inversionRepository.findAllByCategoria(categoria);
    }

    public Inversion updateInversion(Integer id, Inversion inversion){
        Optional<Inversion> optInversion = this.inversionRepository.findById(id);
        if(optInversion.isEmpty()){
            throw new InversionException("Inversion no encontrada", HttpStatus.NOT_FOUND);
        }
        return this.inversionRepository.save(this.mapper.mapUpdate(inversion,optInversion.get()));
    }

    public void deleteInversion(Integer id){
        Optional<Inversion> optInversion = this.inversionRepository.findById(id);
        if(optInversion.isEmpty()){
            throw new InversionException("Inversion no encontrada", HttpStatus.NOT_FOUND);
        }
        this.inversionRepository.deleteById(id);
    }

    public Categoria[] getAllCategoria(){
        return Categoria.values();
    }

    public Moneda[] getAllMoneda(){
        return Moneda.values();
    }
}
