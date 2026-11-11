package com.ito.GFOPact3_t4.controllers;

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

    // LEER (Listar todos)
    @GetMapping
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.listarTodos());
        return "lista";
    }

    // CREAR (Mostrar formulario)
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("equipos", equipoService.listarTodos());
        return "formulario";
    }

    // CREAR/ACTUALIZAR (Guardar en BD)
    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorService.guardar(jugador);
        return "redirect:/jugadores";
    }

    // ACTUALIZAR (Cargar datos en formulario)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorService.obtenerPorId(id));
        model.addAttribute("equipos", equipoService.listarTodos());
        return "formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return "redirect:/jugadores";
    }
}