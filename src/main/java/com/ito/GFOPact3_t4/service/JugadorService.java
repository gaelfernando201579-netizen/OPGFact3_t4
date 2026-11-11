package com.ito.GFOPact3_t4.service;

import com.ito.GFOPact3_t4.models.Jugador;
import com.ito.GFOPact3_t4.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    // Inyección de dependencias
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // LEER: Obtiene todos los jugadores
    public List<Jugador> listarTodos() {
        return jugadorRepository.findAll();
    }

    // CREAR / ACTUALIZAR: Guarda un jugador en la base de datos
    public void guardar(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

    // LEER UNO: Busca un jugador por su ID (para poder editarlo)
    public Jugador obtenerPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    // ELIMINAR: Borra un jugador por su ID
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }
}
