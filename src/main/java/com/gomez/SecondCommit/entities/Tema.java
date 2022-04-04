package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(columnDefinition = "boolean default false")
    private Boolean fijado;


    @JsonIgnoreProperties(value={"preguntas", "temas"})
    @ManyToOne
    @JoinColumn(name="curso_id", foreignKey = @ForeignKey(name="fk_tema_curso"))
    private Curso curso;

/*    @JsonIgnoreProperties(value="tema")
    @OneToMany(mappedBy = "tema")
    private List<Respuesta> respuestas;*/

    @JsonIgnoreProperties(value="tema")
    @OneToMany(mappedBy = "tema")
    private List<Pregunta> preguntas;

/*    @JsonIgnoreProperties(value="tema")
    @OneToMany(mappedBy = "tema")
    private List<Discusion> discusiones;*/

    public Tema() {

    }

    public Tema(Long id, String nombre, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fijado = false;
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

    public Boolean getFijado() {
        return fijado;
    }

    public void setFijado(Boolean fijado) {
        this.fijado = fijado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

/*    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }*/

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
/*

    public List<Discusion> getDiscusiones() {
        return discusiones;
    }

    public void setDiscusiones(List<Discusion> discusiones) {
        this.discusiones = discusiones;
    }
*/

    @Override
    public String toString() {
        return "Tema{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", curso=" + curso +
/*                ", respuestas=" + respuestas +*/
                ", preguntas=" + preguntas +
                '}';
    }
}

