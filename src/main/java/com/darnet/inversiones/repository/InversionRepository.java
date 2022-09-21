package com.darnet.inversiones.repository;

import com.darnet.inversiones.model.Categoria;
import com.darnet.inversiones.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InversionRepository extends JpaRepository<Inversion, Integer> {

    public List<Inversion> findAllByCategoria(Categoria categoria);
}
