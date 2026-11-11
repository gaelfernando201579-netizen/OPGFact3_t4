package com.ito.GFOPact3_t4.service;

import com.ito.GFOPact3_t4.models.Equipo;
import com.ito.GFOPact3_t4.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    // Inyección de dependencias
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    // Método para listar todos los equipos (útil para el <select> en el HTML)
    public List<Equipo> listarTodos() {
        return equipoRepository.findAll();
    }
}
