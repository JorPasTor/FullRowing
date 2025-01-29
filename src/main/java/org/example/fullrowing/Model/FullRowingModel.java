package org.example.fullrowing.Model;

import org.example.fullrowing.ConectionDB;
import org.example.fullrowing.Model.Entities.DeportistasEntity;
import org.example.fullrowing.Model.Entities.EntrenadoresEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class FullRowingModel {

    public FullRowingModel(){

    }

//region Deportistas
    public void addDeportistas(String nombreDep, String primerApellidoDep, String segundoApellidoDep, String dniDep, boolean generoDep, int anoNacDep, boolean modalidadBancoFijo, boolean modalidadBancoMovil, int peso, int wats) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            DeportistasEntity newDeportista = new DeportistasEntity();

            newDeportista.setNombre(nombreDep);
            newDeportista.setPrimerApellido(primerApellidoDep);
            newDeportista.setSegundoApellido(segundoApellidoDep);
            newDeportista.setDni(dniDep);
            newDeportista.setGenero(generoDep);
            newDeportista.setAñonac(anoNacDep);
            newDeportista.setBancoFijo(modalidadBancoFijo);
            newDeportista.setBancoMovil(modalidadBancoMovil);
            newDeportista.setKg(peso);
            newDeportista.setWats(wats);

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
    public void editarDeportista(String idDep, String nombreDep, String primerApellidoDep, String segundoApellidoDep, String dniDep, boolean generoDep, int anoNacDep, boolean modalidadBancoMovil, boolean modalidadBancoFijo, int peso, int wats) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Buscar el deportista existente por ID
            DeportistasEntity existingDeportista = session.get(DeportistasEntity.class, idDep);

            if (existingDeportista != null) {
                // Actualizar los valores del deportista
                existingDeportista.setNombre(nombreDep);
                existingDeportista.setPrimerApellido(primerApellidoDep);
                existingDeportista.setSegundoApellido(segundoApellidoDep);
                existingDeportista.setDni(dniDep);
                existingDeportista.setGenero(generoDep);
                existingDeportista.setAñonac(anoNacDep);
                existingDeportista.setBancoMovil(modalidadBancoMovil);
                existingDeportista.setBancoFijo(modalidadBancoFijo);
                existingDeportista.setKg(peso);
                existingDeportista.setWats(wats);

                // Guardar los cambios
                session.update(existingDeportista);
                transaction.commit();
            } else {
                System.out.println("No se encontró ningún deportista con el ID: " + idDep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public boolean deportistaExist(String idDep){
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) FROM DeportistasEntity d WHERE d.iddeportista = :idDep";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idDep", idDep);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deportistaExistDni(String dniDep) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) FROM DeportistasEntity d WHERE d.dni = :dniDep";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("dniDep", dniDep);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//endregion

//region Entrenadores
    public void addEntrenador(String nombreEnt, String primerApellidoEnt, String segundoApellidoEnt, String dniEntText, boolean generoEnt) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            EntrenadoresEntity newEntrenador = new EntrenadoresEntity();

            newEntrenador.setNombre(nombreEnt);
            newEntrenador.setPrimerApellido(primerApellidoEnt);
            newEntrenador.setSegundoApellido(segundoApellidoEnt);
            newEntrenador.setDni(dniEntText);
            newEntrenador.setGenero(generoEnt);

            session.save(newEntrenador);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public EntrenadoresEntity searchEntrenador(String dni) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM EntrenadoresEntity c " +
                    "WHERE (c.dni) = :dni";

            Query<EntrenadoresEntity> query = session.createQuery(hql, EntrenadoresEntity.class);
            query.setParameter("dni", dni);

            return query.uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void editarEntrenador(String idEnt, String nombreEnt, String primerApellidoEnt, String segundoApellidoEnt, String dniEnt, boolean generoEnt) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Buscar el deportista existente por ID
            DeportistasEntity existingDeportista = session.get(DeportistasEntity.class, idEnt);

            if (existingDeportista != null) {
                // Actualizar los valores del entrenador
                existingDeportista.setNombre(nombreEnt);
                existingDeportista.setPrimerApellido(primerApellidoEnt);
                existingDeportista.setSegundoApellido(segundoApellidoEnt);
                existingDeportista.setDni(dniEnt);
                existingDeportista.setGenero(generoEnt);

                // Guardar los cambios
                session.update(existingDeportista);
                transaction.commit();
            } else {
                System.out.println("No se encontró ningún entrenador con el ID: " + idEnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteEntrenador(String idEnt) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Buscar el deportista por ID
            EntrenadoresEntity entrenadores = session.get(EntrenadoresEntity.class, idEnt);

            if (entrenadores != null) {
                // Eliminar la entidad si existe
                session.delete(entrenadores);
                transaction.commit();
            } else {
                System.out.println("No se encontró ningún deportista con el ID: " + idEnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean entrenadorExist(String idEnt) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) FROM EntrenadoresEntity e WHERE e.ident = :idEnt";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idEnt", idEnt);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean entrenadorExistDni(String dniEnt) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) FROM EntrenadoresEntity e WHERE e.dni = :dniEnt";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("dniEnt", dniEnt);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//endregion

//region Categorias
    public boolean categoriaEntrenadorExist(int idCategoria) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(*) \n" +
                    "FROM CategoriasEntity c \n" +
                    "WHERE c.idcategoria = :idCat \n" +
                    "  AND c.entrenadoresByIdEntrenador IS NOT NULL";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idCat", idCategoria);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Integer entrenadorCategoria(int idCategoria) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT c.entrenadoresByIdEntrenador.ident " +
                    "FROM CategoriasEntity c " +
                    "WHERE c.idcategoria = :idCat";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("idCat", idCategoria);

            return query.uniqueResult(); // Devuelve el idEntrenador o null si no existe
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null en caso de error
        }
    }
    public void addEntrenadorCategoria(int idCategoria, int idEntrenador) {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "UPDATE CategoriasEntity c " +
                    "SET c.entrenadoresByIdEntrenador = (SELECT e FROM EntrenadoresEntity e WHERE e.ident = :idEnt) " +
                    "WHERE c.idcategoria = :idCat";
            Query<?> query = session.createQuery(hql);
            query.setParameter("idEnt", idEntrenador);
            query.setParameter("idCat", idCategoria);

            int rowsAffected = query.executeUpdate();
            transaction.commit();

            if (rowsAffected > 0) {
                System.out.println("El entrenador con ID " + idEntrenador + " ha sido asignado a la categoría con ID " + idCategoria);
            } else {
                System.out.println("No se encontró la categoría con ID " + idCategoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//endregion

//region Estadisticas
    public int countCM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac IN (2009, 2010) AND c.genero = true";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countCF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac IN (2009, 2010) AND c.genero = false";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countJM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac IN (2007, 2008) AND c.genero = true";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countJF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac IN (2007, 2008) AND c.genero = false";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countSM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac IN (1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006) AND c.genero = true";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countSF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac IN (1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006) AND c.genero = false";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countVM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac <= 1994 AND c.genero = true";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }
    public int countVF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            String hql = "SELECT COUNT(c) FROM DeportistasEntity c " +
                    "WHERE c.añonac <= 1994 AND c.genero = false";

            Query<Long> query = session.createQuery(hql, Long.class);

            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0; // Convertir Long a int y manejar nulos
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 en caso de error
    }

    public DeportistasEntity recordCM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac IN (2009, 2010) AND d.genero = true " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordCF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac IN (2009, 2010) AND d.genero = false " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordJM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac IN (2007, 2008) AND d.genero = true " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordJF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac IN (2007, 2008) AND d.genero = false " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordSM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac IN (1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006) AND d.genero = true " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordSF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac IN (1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006) AND d.genero = false " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordVM() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac <= 1994 AND d.genero = true " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }
    public DeportistasEntity recordVF() {
        try (Session session = ConectionDB.getSessionFactory().openSession()) {
            // Consulta HQL para obtener el deportista con el valor máximo en wats
            String hql = "FROM DeportistasEntity d " +
                    "WHERE d.añonac <= 1994 AND d.genero = false " +
                    "ORDER BY d.wats DESC";

            Query<DeportistasEntity> query = session.createQuery(hql, DeportistasEntity.class);
            query.setMaxResults(1); // Recuperar solo un registro (el de mayor wats)

            DeportistasEntity result = query.uniqueResult();
            return result; // Devuelve el deportista encontrado o null si no hay ninguno
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null en caso de error
    }




//endregion


}
