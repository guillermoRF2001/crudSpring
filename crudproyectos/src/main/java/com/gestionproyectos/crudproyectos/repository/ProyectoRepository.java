package com.gestionproyectos.crudproyectos.repository;

import com.gestionproyectos.crudproyectos.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
