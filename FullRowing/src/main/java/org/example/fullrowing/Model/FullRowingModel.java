package org.example.fullrowing.Model;

import org.example.fullrowing.ConectionDB;
import org.example.fullrowing.Model.Entities.DeportistasEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;

public class FullRowingModel {

    public FullRowingModel(){

    }

    public void addDeportistas(String nombreDep, String primerApellidoDep, String segundoApellidoDep, String dniDep, boolean generoDep, int anoNacDep, boolean modalidadBancoFijo, boolean modalidadBancoMovil) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            DeportistasEntity newDeportista = new DeportistasEntity();

            newDeportista.setNombre(nombreDep);
            newDeportista.setPrimerApellido(primerApellidoDep);
            newDeportista.setSegundoApellido(segundoApellidoDep);
            newDeportista.setDni(dniDep);
            newDeportista.setGenero(generoDep);
            newDeportista.setAñoNac(anoNacDep);
            newDeportista.setBancoFijo(modalidadBancoFijo);
            newDeportista.setBancoMovil(modalidadBancoMovil);

            session.save(newDeportista);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DeportistasEntity searchDeportista(String dni){

        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM DeportistasEntity c " +
                    "WHERE (c.dni) = :dni";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setParameter("dni", dni);

            return query.uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteDeportista(String idDeportista){
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Buscar el deportista por ID
            DeportistasEntity deportista = session.get(DeportistasEntity.class, idDeportista);

            if (deportista != null) {
                // Eliminar la entidad si existe
                session.delete(deportista);
                transaction.commit();
            } else {
                System.out.println("No se encontró ningún deportista con el ID: " + idDeportista);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
