package com.gestionproyectos.crudproyectos.service;

import com.gestionproyectos.crudproyectos.model.Proyecto;
import com.gestionproyectos.crudproyectos.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Optional<Proyecto> obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
