package com.gomez.SecondCommit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=45, unique = true)
    private String email;

    @Column(nullable=false, length=45)
    private String username;

    @Column(nullable=false)
    @JsonIgnore
    private String password;

    @JsonIgnoreProperties(value="usuario")
    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    @JsonIgnoreProperties(value="usuario")
    @OneToMany(mappedBy = "usuario")
    private List<Pregunta> preguntas;

    @JsonIgnoreProperties(value="usuario")
    @OneToMany(mappedBy = "usuario")
    private List<Voto> votos;

    @JsonIgnoreProperties(value="usuario")
    @OneToMany()
    @JoinColumn(name="notificaciones", foreignKey= @ForeignKey(name="fk_usuario_notificacion"))
    private List<Notificacion> notificaciones;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID", foreignKey=@ForeignKey(name="fk_user_id"))
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID", foreignKey=@ForeignKey(name="fk_user_id")) })
    private Set<Role> roles;


    public Usuario() {
    }

    public Usuario(Long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", respuestas=" + respuestas +
                ", preguntas=" + preguntas +
                ", votos=" + votos +
                ", notificaciones=" + notificaciones +
                ", roles=" + roles +
                '}';
    }
}
