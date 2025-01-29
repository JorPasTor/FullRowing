package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "anuncios", schema = "public", catalog = "FullRowing")
public class AnunciosEntity {
    private int idAnuncio;
    private String titulo;
    private String mensaje;
    private Timestamp fechaPublicacion;
    private int idEmisor;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_anuncio", nullable = false)
    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    @Basic
    @Column(name = "titulo", nullable = false, length = -1)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "mensaje", nullable = false, length = -1)
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Basic
    @Column(name = "fecha_publicacion", nullable = false)
    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Basic
    @Column(name = "id_emisor", nullable = false)
    public int getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnunciosEntity that = (AnunciosEntity) o;
        return idAnuncio == that.idAnuncio && idEmisor == that.idEmisor && Objects.equals(titulo, that.titulo) && Objects.equals(mensaje, that.mensaje) && Objects.equals(fechaPublicacion, that.fechaPublicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnuncio, titulo, mensaje, fechaPublicacion, idEmisor);
    }
}
