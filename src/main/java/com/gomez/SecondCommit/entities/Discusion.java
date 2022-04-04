/*
package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Discusion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name="pregunta_id", foreignKey= @ForeignKey(name="fk_discusion_pregunta"))
    private Pregunta pregunta;

    @OneToMany(mappedBy = "discusion")
    private List<Respuesta> respuestas;

    @JsonIgnoreProperties(value="discusion")
    @ManyToOne
    @JoinColumn(name="tema_id", foreignKey= @ForeignKey(name="fk_discusion_tema"))
    private Tema tema;

    public Discusion() {
    }

    public Discusion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Discusion{" +
                "id=" + id +
                ", pregunta=" + pregunta +
                ", respuestas=" + respuestas +
                ", tema=" + tema +
                '}';
    }
}
*/
