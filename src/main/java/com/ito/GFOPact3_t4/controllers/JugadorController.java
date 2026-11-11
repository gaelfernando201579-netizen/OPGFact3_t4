package com.ito.GFOPact3_t4.controllers;

import com.ito.GFOPact3_t4.models.Equipo;
import com.ito.GFOPact3_t4.models.Jugador;
import com.ito.GFOPact3_t4.service.EquipoService;
import com.ito.GFOPact3_t4.service.JugadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;
    private final EquipoService equipoService;

    public JugadorController(JugadorService jugadorService, EquipoService equipoService) {
        this.jugadorService = jugadorService;
        this.equipoService = equipoService;
    }

    @GetMapping
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.listarTodos());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        Jugador jugador = new Jugador();
        jugador.setEquipo(new Equipo());
        model.addAttribute("jugador", jugador);
        model.addAttribute("equipos", equipoService.listarTodos());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        Long equipoId = (jugador.getEquipo() != null) ? jugador.getEquipo().getId() : null;
        jugador.setEquipo(equipoId != null ? equipoService.obtenerPorId(equipoId) : null);
        jugadorService.guardar(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorService.obtenerPorId(id);
        if (jugador != null && jugador.getEquipo() == null) {
            jugador.setEquipo(new Equipo());
        }
        model.addAttribute("jugador", jugador);
        model.addAttribute("equipos", equipoService.listarTodos());
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return "redirect:/jugadores";
    }
}