package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean fijado;


    @JsonIgnoreProperties(value= {"preguntas", "respuestas"})
    @ManyToOne
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_pregunta_usuario"))
    private Usuario usuario;

    /*@JsonIgnoreProperties(value={"preguntas", "temas"})
    @ManyToOne
    @JoinColumn(name="curso_id", foreignKey = @ForeignKey(name = "fk_pregunta_curso"))
    private Curso curso;*/

    @JsonIgnoreProperties(value= {"preguntas", "discusiones"})
    @ManyToOne
    @JoinColumn(name="tema_id", foreignKey = @ForeignKey(name = "fk_pregunta_tema"))
    private Tema tema;

    @JsonIgnoreProperties(value="preguntas")
    @OneToMany
    @JoinTable(name = "pregunta_voto",
            joinColumns = {
                    @JoinColumn(name = "pregunta_id", foreignKey=@ForeignKey(name="fk_pregunta_id"))
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "voto_id", foreignKey=@ForeignKey(name="fk_voto_id")) })
    private List<Voto> votos;

    @JsonIgnoreProperties(value={"pregunta"})
    @OneToMany(mappedBy="pregunta")
    //@JoinColumn(name="respuestas", foreignKey=@ForeignKey(name="fk_pregunta_respuestas"))
    private List<Respuesta> respuestas;

    //@GeneratedValue(strategy = GenerationType.)
    //private Integer totalRespuestas;

    @JsonIgnoreProperties(value="pregunta")
    @OneToMany(mappedBy = "pregunta")
    private List<Notificacion> notificaciones;

/*
    @JsonIgnoreProperties(value="discusion")
    //@JoinColumn(name="discusion_id", foreignKey = @ForeignKey(name = "fk_pregunta_discusion"))
    @OneToOne(mappedBy="pregunta")
    private Discusion discusion;
*/


    public Pregunta() {
    }

    public Pregunta(Long id, String titulo, String descripcion, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.categoria = categoria;
        this.fijado = false;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   /* public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }*/

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;

    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

/*    public Discusion getDiscusion() {
        return discusion;
    }

    public void setDiscusion(Discusion discusion) {
        this.discusion = discusion;
    }*/


    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", categoria=" + categoria +
                ", usuario=" + usuario +
    /*            ", curso=" + curso +*/
                ", tema=" + tema +
                ", voto=" + votos +
                ", respuestas=" + respuestas +
                ", notificaciones=" + notificaciones +
/*                ", discusion=" + discusion +*/
                '}';
    }
}
