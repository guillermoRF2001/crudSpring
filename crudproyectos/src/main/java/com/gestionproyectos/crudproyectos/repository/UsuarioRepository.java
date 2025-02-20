package com.gestionproyectos.crudproyectos.repository;

import com.gestionproyectos.crudproyectos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
