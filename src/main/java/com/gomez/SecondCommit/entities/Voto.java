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
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_voto_usuario"))
    private Usuario usuario;

    @JsonIgnoreProperties(value="voto")
    @OneToMany(mappedBy = "voto")
    private List<Respuesta> respuestas;

    @JsonIgnoreProperties(value="voto")
    @OneToMany(mappedBy = "usuario")
    private List<Pregunta> preguntas;

}
