package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties(value="notificaciones")
    @ManyToOne
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_notificacion_usuario"))
    private Usuario usuario;

    @JsonIgnoreProperties(value="notificacion")
    @ManyToOne
    @JoinColumn(name="pregunta_id", foreignKey = @ForeignKey(name = "fk_notificacion_pregunta"))
    private Pregunta pregunta;

    public Notificacion() {
    }

    public Notificacion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Notificacion{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", pregunta=" + pregunta +
                '}';
    }
}
