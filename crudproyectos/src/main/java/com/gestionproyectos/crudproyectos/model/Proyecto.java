package com.gestionproyectos.crudproyectos.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false, name = "fecha_inicio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Asegúrate de usar minúsculas para el patrón
    private String fecha_inicio;

    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Tarea> tareas;


    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String fechaInicio, EstadoProyecto estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fechaInicio;
        this.estado = estado;
    }

    public enum EstadoProyecto {
        ACTIVO, EN_PROGRESO, FINALIZADO
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fecha_inicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fecha_inicio = fechaInicio;
    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
