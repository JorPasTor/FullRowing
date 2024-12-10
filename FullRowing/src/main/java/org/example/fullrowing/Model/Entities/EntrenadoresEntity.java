package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Entrenadores", schema = "public", catalog = "FullRowing")
public class EntrenadoresEntity {
    private int idEnt;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private Integer idCategoria;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdEnt", nullable = false)
    public int getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(int idEnt) {
        this.idEnt = idEnt;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = -1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Primer_Apellido", nullable = true, length = -1)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "Segundo_Apellido", nullable = true, length = -1)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Basic
    @Column(name = "DNI", nullable = true, length = -1)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "IdCategoria", nullable = true)
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadoresEntity that = (EntrenadoresEntity) o;
        return idEnt == that.idEnt && Objects.equals(nombre, that.nombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(dni, that.dni) && Objects.equals(idCategoria, that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnt, nombre, primerApellido, segundoApellido, dni, idCategoria);
    }
}
