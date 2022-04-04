package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gomez.SecondCommit.repositories.PreguntaRepository;
import com.gomez.SecondCommit.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private LocalDateTime fecha;

    private Boolean fijado;

    @JsonIgnoreProperties(value={"respuestas", "preguntas"})
    @ManyToOne
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name = "fk_respuesta_usuario"))
    private Usuario usuario;

    @JsonIgnoreProperties(value= {"respuestas", "discusion"})
    @ManyToOne
    @JoinColumn(name="pregunta_id", foreignKey = @ForeignKey(name = "fk_respuesta_pregunta"), nullable=false)
    private Pregunta pregunta;

    @JsonIgnoreProperties(value="respuestas")
    @OneToMany
    //@JoinColumn(name="voto_id", foreignKey = @ForeignKey(name = "fk_respuesta_voto"))
    @JoinTable(name = "respuesta_voto",
            joinColumns = {
                    @JoinColumn(name = "respuesta_id", foreignKey=@ForeignKey(name="fk_respuesta_id"))
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "voto_id", foreignKey=@ForeignKey(name="fk_voto_id")) })
    private List<Voto> votos;

    @JsonIgnore
    @JsonIgnoreProperties(value= {"preguntas"})
    @ManyToOne
    @JoinColumn(name="tema_id", foreignKey = @ForeignKey(name = "fk_respuesta_tema"))
    private Tema tema;

/*    @JsonIgnoreProperties(value= {"respuestas"})
    @ManyToOne
    @JoinColumn(name="discusion_id", foreignKey=@ForeignKey(name = "fk_respuesta_discusion"))
    private Discusion discusion;*/

    public Respuesta() {
    }

    public Respuesta(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.fijado = false;

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

    public Pregunta getPregunta() {
        return pregunta;
    }


    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

/*    public Discusion getDiscusion() {
        return discusion;
    }

    public void setDiscusion(Discusion discusion) {
        this.discusion = discusion;
    }*/

    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", verificado=" + fijado +
                ", usuario=" + usuario +
                ", pregunta=" + pregunta +
                ", voto=" + votos +
                ", tema=" + tema +
/*                ", discusion=" + discusion +*/
                '}';
    }
}
