package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="curso_id", foreignKey = @ForeignKey(name="fk_tema_curso"))
    private Curso curso;

    @JsonIgnoreProperties(value="tema")
    @OneToMany(mappedBy = "tema")
    private List<Respuesta> respuestas;

    @JsonIgnoreProperties(value="tema")
    @OneToMany(mappedBy = "tema")
    private List<Pregunta> preguntas;

    @JsonIgnoreProperties(value="tema")
    @OneToMany(mappedBy = "tema")
    private List<Discusion> discusion;

    public Tema() {

    }

    public Tema(Long id, String nombre, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Discusion> getDiscusiones() {
        return discusion;
    }

    public void setDiscusiones(List<Discusion> discusiones) {
        this.discusion = discusiones;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", curso=" + curso +
                ", respuestas=" + respuestas +
                ", preguntas=" + preguntas +
                '}';
    }
}

