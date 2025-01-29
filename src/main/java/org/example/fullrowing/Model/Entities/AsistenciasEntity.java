package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "asistencias", schema = "public", catalog = "FullRowing")
public class AsistenciasEntity {
    private int idAsistencia;
    private Date fecha;
    private String estadoAsistencia;
    private DeportistasEntity deportistasByIdDeportista;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_asistencia", nullable = false)
    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    @Basic
    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "estado_asistencia", nullable = false, length = -1)
    public String getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(String estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    @ManyToOne
    @JoinColumn(name = "id_deportista", referencedColumnName = "iddeportista", nullable = false)
    public DeportistasEntity getDeportistasByIdDeportista() {
        return deportistasByIdDeportista;
    }

    public void setDeportistasByIdDeportista(DeportistasEntity deportistasByIdDeportista) {
        this.deportistasByIdDeportista = deportistasByIdDeportista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistenciasEntity that = (AsistenciasEntity) o;
        return idAsistencia == that.idAsistencia &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(estadoAsistencia, that.estadoAsistencia) &&
                Objects.equals(deportistasByIdDeportista, that.deportistasByIdDeportista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsistencia, fecha, estadoAsistencia, deportistasByIdDeportista);
    }
}
