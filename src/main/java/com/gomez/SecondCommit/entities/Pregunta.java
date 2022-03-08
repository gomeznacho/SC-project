package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnoreProperties(value="preguntas")
    @ManyToOne
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_pregunta_usuario"))
    private Usuario usuario;

    @JsonIgnoreProperties(value="preguntas")
    @ManyToOne
    @JoinColumn(name="curso_id", foreignKey = @ForeignKey(name = "fk_pregunta_curso"))
    private Curso curso;

    @JsonIgnoreProperties(value="preguntas")
    @ManyToOne
    @JoinColumn(name="tema_id", foreignKey = @ForeignKey(name = "fk_pregunta_tema"))
    private Tema tema;

    @JsonIgnoreProperties(value="preguntas")
    @ManyToOne
    @JoinColumn(name="voto_id", foreignKey = @ForeignKey(name = "fk_pregunta_voto"))
    private Voto voto;

    @JsonIgnoreProperties(value={"preguntas"})
    @OneToMany(mappedBy = "pregunta")
    private List<Respuesta> respuestas;

    @JsonIgnoreProperties(value="pregunta")
    @OneToMany(mappedBy = "pregunta")
    private List<Notificacion> notificaciones;

    @JsonIgnoreProperties(value="discusion")
    //@JoinColumn(name="discusion_id", foreignKey = @ForeignKey(name = "fk_pregunta_discusion"))
    @OneToOne(mappedBy="pregunta")
    private Discusion discusion;


    public Pregunta() {
    }

    public Pregunta(Long id, String titulo, String descripcion, LocalDateTime fecha, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
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

    public Discusion getDiscusion() {
        return discusion;
    }

    public void setDiscusion(Discusion discusion) {
        this.discusion = discusion;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", categoria=" + categoria +
                ", usuario=" + usuario +
                ", curso=" + curso +
                ", tema=" + tema +
                ", voto=" + voto +
                ", respuestas=" + respuestas +
                ", notificaciones=" + notificaciones +
                ", discusion=" + discusion +
                '}';
    }
}
