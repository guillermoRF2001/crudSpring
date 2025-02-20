package com.gestionproyectos.crudproyectos.controller;

import com.gestionproyectos.crudproyectos.model.Proyecto;
import com.gestionproyectos.crudproyectos.model.Tarea;
import com.gestionproyectos.crudproyectos.service.ProyectoService;
import com.gestionproyectos.crudproyectos.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;
    private final ProyectoService proyectoService;

    public TareaController(TareaService tareaService, ProyectoService proyectoService) {
        this.tareaService = tareaService;
        this.proyectoService = proyectoService;
    }

    @GetMapping("/crear/{proyectoId}")
    public String mostrarFormularioCrear(@PathVariable Long proyectoId, Model model) {
        Tarea tarea = new Tarea();
        model.addAttribute("tarea", tarea);
        model.addAttribute("proyectoId", proyectoId);
        return "tareas/formulario";
    }

    @PostMapping
    public String guardarTarea(@ModelAttribute Tarea tarea, @RequestParam Long proyectoId) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(proyectoId)
                .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
        tarea.setProyecto(proyecto);
        tareaService.guardarTarea(tarea);
        return "redirect:/proyectos/" + proyectoId;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        // Primero obtenemos la tarea para saber a qué proyecto pertenece
        Tarea tarea = tareaService.obtenerTareaPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada"));
        Long proyectoId = tarea.getProyecto().getId();
        tareaService.eliminarTarea(id);
        return "redirect:/proyectos/" + proyectoId;
    }
}
