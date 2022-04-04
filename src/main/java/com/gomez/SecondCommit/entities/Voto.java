package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean likeDislike;

    @ManyToOne
   // @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_voto_usuario"))
    private Usuario usuario;
/*
   // @JsonIgnoreProperties(value="voto")
    @ManyToOne(targetEntity = Respuesta.class)
    private Respuesta respuesta;

    //@JsonIgnoreProperties(value="voto")
    @ManyToOne(targetEntity =Pregunta.class)
    private Pregunta pregunta;
*/

    public Voto() {
    }

    public Voto(Long id, Boolean likeDislike) {
        this.id = id;
        this.likeDislike = likeDislike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLikeDislike() {
        return likeDislike;
    }

    public void setLikeDislike(Boolean likeDislike) {
        this.likeDislike = likeDislike;
    }
}
