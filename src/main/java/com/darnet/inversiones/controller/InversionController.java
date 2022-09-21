package com.darnet.inversiones.controller;

import com.darnet.inversiones.model.Categoria;
import com.darnet.inversiones.model.Inversion;
import com.darnet.inversiones.model.Moneda;
import com.darnet.inversiones.services.InversionService;
import com.darnet.inversiones.services.dto.InversionInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/inversions")
public class InversionController {

    private final InversionService inversionService;

    public InversionController(InversionService inversionService) {
        this.inversionService = inversionService;
    }

    @GetMapping("")
    public List<Inversion> getAll(){
        return inversionService.listAll();
    }

    @PostMapping("/add")
    public Inversion createTask(@RequestBody InversionInDTO inversionInDTO){
        return this.inversionService.saveInversion(inversionInDTO);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Inversion> findByCategoria(@PathVariable("categoria") Categoria categoria){
        return inversionService.findbyCategoria(categoria);
    }

    @PutMapping("/update/{id}")
    public Inversion updateInversion(@PathVariable Integer id, @RequestBody Inversion inversion){
        return inversionService.updateInversion(id, inversion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInversion(@PathVariable Integer id){
        this.inversionService.deleteInversion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categorias")
    public Categoria[] listAllCategories(){
        return this.inversionService.getAllCategoria();
    }

    @GetMapping("/monedas")
    public Moneda[] listAllMoneda(){
        return this.inversionService.getAllMoneda();
    }
}

