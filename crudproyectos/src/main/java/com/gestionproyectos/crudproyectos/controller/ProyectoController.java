package com.gestionproyectos.crudproyectos.controller;

import com.gestionproyectos.crudproyectos.model.Proyecto;
import com.gestionproyectos.crudproyectos.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public String listarProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.listarProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos/lista";  
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "proyectos/formulario";
    }

    @PostMapping
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoService.guardarProyecto(proyecto);
        return "redirect:/proyectos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return "redirect:/proyectos";
    }

    @GetMapping("/{id}")
    public String verDetalleProyecto(@PathVariable Long id, Model model) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
        model.addAttribute("proyecto", proyecto);
        return "proyectos/detalle";
    }
}
