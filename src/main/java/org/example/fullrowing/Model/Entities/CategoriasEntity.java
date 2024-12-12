package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "categorias", schema = "public", catalog = "FullRowing")
public class CategoriasEntity {
    private int idCategoria;
    private String nombreCategoria;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IdCategoria", nullable = false)
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Basic
    @Column(name = "Nombre_Categoria", nullable = false, length = -1)
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriasEntity that = (CategoriasEntity) o;
        return idCategoria == that.idCategoria && Objects.equals(nombreCategoria, that.nombreCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nombreCategoria);
    }
}
