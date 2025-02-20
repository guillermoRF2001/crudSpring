package com.gestionproyectos.crudproyectos.service;

import com.gestionproyectos.crudproyectos.model.Tarea;
import com.gestionproyectos.crudproyectos.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public List<Tarea> listarTareasPorProyecto(Long proyectoId) {
        return tareaRepository.findByProyectoId(proyectoId);
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
