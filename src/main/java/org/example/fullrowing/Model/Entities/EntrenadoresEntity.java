package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "entrenadores", schema = "public", catalog = "FullRowing")
public class EntrenadoresEntity {
    private int ident;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private Boolean genero;
    private Integer idcategoria;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ident", nullable = false)
    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = -1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "primer_apellido", nullable = true, length = -1)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "segundo_apellido", nullable = true, length = -1)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Basic
    @Column(name = "dni", nullable = true, length = -1)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "genero", nullable = true)
    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    @Basic
    @Column(name = "idcategoria", nullable = true)
    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntrenadoresEntity that = (EntrenadoresEntity) o;
        return ident == that.ident && Objects.equals(nombre, that.nombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(dni, that.dni) && Objects.equals(genero, that.genero) && Objects.equals(idcategoria, that.idcategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ident, nombre, primerApellido, segundoApellido, dni, genero, idcategoria);
    }
}
