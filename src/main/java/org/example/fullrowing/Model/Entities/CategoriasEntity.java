package org.example.fullrowing.Model.Entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorias", schema = "public", catalog = "FullRowing")
public class CategoriasEntity {
    private int idcategoria;
    private String nombreCategoria;
    private EntrenadoresEntity entrenadoresByIdEntrenador;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategoria", nullable = false)
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Basic
    @Column(name = "nombre_categoria", nullable = false, length = -1)
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @ManyToOne
    @JoinColumn(name = "id_entrenador", referencedColumnName = "ident", nullable = true)
    public EntrenadoresEntity getEntrenadoresByIdEntrenador() {
        return entrenadoresByIdEntrenador;
    }

    public void setEntrenadoresByIdEntrenador(EntrenadoresEntity entrenadoresByIdEntrenador) {
        this.entrenadoresByIdEntrenador = entrenadoresByIdEntrenador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriasEntity that = (CategoriasEntity) o;
        return idcategoria == that.idcategoria &&
                Objects.equals(nombreCategoria, that.nombreCategoria) &&
                Objects.equals(entrenadoresByIdEntrenador, that.entrenadoresByIdEntrenador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcategoria, nombreCategoria, entrenadoresByIdEntrenador);
    }
}
