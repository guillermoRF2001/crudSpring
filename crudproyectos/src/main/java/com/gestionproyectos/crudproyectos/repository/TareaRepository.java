package com.gestionproyectos.crudproyectos.repository;

import com.gestionproyectos.crudproyectos.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByProyectoId(Long proyectoId);
}
