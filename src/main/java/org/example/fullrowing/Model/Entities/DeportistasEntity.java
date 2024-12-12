package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "deportistas", schema = "public", catalog = "FullRowing")
public class DeportistasEntity {
    private int iddeportista;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private Integer categoria;
    private Boolean bancoFijo;
    private Boolean bancoMovil;
    private Integer añonac;
    private Boolean genero;
    private Integer kg;
    private Integer wats;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddeportista", nullable = false)
    public int getIddeportista() {
        return iddeportista;
    }

    public void setIddeportista(int iddeportista) {
        this.iddeportista = iddeportista;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = -1)
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
    @Column(name = "dni", nullable = false, length = -1)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "categoria", nullable = true)
    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "banco_fijo", nullable = true)
    public Boolean getBancoFijo() {
        return bancoFijo;
    }

    public void setBancoFijo(Boolean bancoFijo) {
        this.bancoFijo = bancoFijo;
    }

    @Basic
    @Column(name = "banco_movil", nullable = true)
    public Boolean getBancoMovil() {
        return bancoMovil;
    }

    public void setBancoMovil(Boolean bancoMovil) {
        this.bancoMovil = bancoMovil;
    }

    @Basic
    @Column(name = "añonac", nullable = true)
    public Integer getAñonac() {
        return añonac;
    }

    public void setAñonac(Integer añonac) {
        this.añonac = añonac;
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
    @Column(name = "kg", nullable = true)
    public Integer getKg() {
        return kg;
    }

    public void setKg(Integer kg) {
        this.kg = kg;
    }

    @Basic
    @Column(name = "wats", nullable = true)
    public Integer getWats() {
        return wats;
    }

    public void setWats(Integer wats) {
        this.wats = wats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeportistasEntity that = (DeportistasEntity) o;
        return iddeportista == that.iddeportista && Objects.equals(nombre, that.nombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(dni, that.dni) && Objects.equals(categoria, that.categoria) && Objects.equals(bancoFijo, that.bancoFijo) && Objects.equals(bancoMovil, that.bancoMovil) && Objects.equals(añonac, that.añonac) && Objects.equals(genero, that.genero) && Objects.equals(kg, that.kg) && Objects.equals(wats, that.wats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddeportista, nombre, primerApellido, segundoApellido, dni, categoria, bancoFijo, bancoMovil, añonac, genero, kg, wats);
    }
}
