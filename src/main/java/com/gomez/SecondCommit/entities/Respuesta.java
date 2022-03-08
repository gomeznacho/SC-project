package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private LocalDateTime fecha;

    private Boolean verificado;

    @JsonIgnoreProperties(value="respuestas")
    @ManyToOne
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_respuesta_usuario"))
    private Usuario usuario;

    @JsonIgnoreProperties(value="respuestas")
    @ManyToOne
    @JoinColumn(name="pregunta_id", foreignKey = @ForeignKey(name = "fk_respuesta_pregunta"))
    private Pregunta pregunta;

    @JsonIgnoreProperties(value="respuestas")
    @ManyToOne
    @JoinColumn(name="voto_id", foreignKey = @ForeignKey(name = "fk_respuesta_voto"))
    private Voto voto;

    @JsonIgnoreProperties(value="respuestas")
    @ManyToOne
    @JoinColumn(name="tema_id", foreignKey = @ForeignKey(name = "fk_respuesta_tema"))
    private Tema tema;

    @JsonIgnoreProperties(value="respuestas")
    @ManyToOne
    @JoinColumn(name="discusion_id", foreignKey=@ForeignKey(name = "fk_respuesta_discusion"))
    private Discusion discusion;

    public Respuesta() {
    }

    public Respuesta(Long id, String descripcion, LocalDateTime fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Discusion getDiscusion() {
        return discusion;
    }

    public void setDiscusion(Discusion discusion) {
        this.discusion = discusion;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", verificado=" + verificado +
                ", usuario=" + usuario +
                ", pregunta=" + pregunta +
                ", voto=" + voto +
                ", tema=" + tema +
                ", discusion=" + discusion +
                '}';
    }
}
