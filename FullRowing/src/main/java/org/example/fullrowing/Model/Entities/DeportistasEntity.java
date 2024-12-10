package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.Objects;

@Entity
@Table(name = "Deportistas", schema = "public", catalog = "FullRowing")
@DynamicInsert
public class DeportistasEntity {
    private int idDeportista;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private Integer categoria;
    private Boolean bancoFijo;
    private Boolean bancoMovil;
    private Integer añoNac;
    private Boolean genero;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdDeportista", nullable = false)
    public int getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(int idDeportista) {
        this.idDeportista = idDeportista;
    }

    @Basic
    @Column(name = "Nombre", nullable = true, length = -1)
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
    @Column(name = "DNI", nullable = false, length = -1)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "Categoria", nullable = true)
    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "Banco_Fijo", nullable = true)
    public Boolean getBancoFijo() {
        return bancoFijo;
    }

    public void setBancoFijo(Boolean bancoFijo) {
        this.bancoFijo = bancoFijo;
    }

    @Basic
    @Column(name = "Banco_Movil", nullable = true)
    public Boolean getBancoMovil() {
        return bancoMovil;
    }

    public void setBancoMovil(Boolean bancoMovil) {
        this.bancoMovil = bancoMovil;
    }

    @Basic
    @Column(name = "AñoNac", nullable = true)
    public Integer getAñoNac() {
        return añoNac;
    }

    public void setAñoNac(Integer añoNac) {
        this.añoNac = añoNac;
    }

    @Basic
    @Column(name = "Genero", nullable = true)
    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeportistasEntity that = (DeportistasEntity) o;
        return idDeportista == that.idDeportista && Objects.equals(nombre, that.nombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(dni, that.dni) && Objects.equals(categoria, that.categoria) && Objects.equals(bancoFijo, that.bancoFijo) && Objects.equals(bancoMovil, that.bancoMovil) && Objects.equals(añoNac, that.añoNac) && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDeportista, nombre, primerApellido, segundoApellido, dni, categoria, bancoFijo, bancoMovil, añoNac, genero);
    }
}
