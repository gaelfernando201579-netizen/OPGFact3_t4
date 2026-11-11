package com.ito.GFOPact3_t4.service;

import com.ito.GFOPact3_t4.models.Jugador;
import com.ito.GFOPact3_t4.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<Jugador> listarTodos() {
        return jugadorRepository.findAll();
    }

    public void guardar(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

    public Jugador obtenerPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }
}
