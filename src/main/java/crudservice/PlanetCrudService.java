package crudservice;

import entity.Client;
import entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class PlanetCrudService {
    public Planet getPlanetById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        } catch (Exception ex) {
            System.err.println("Planet id is empty");
            return null;
        }
    }

    public void createPlanet(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Planet not created");
        }
    }

    public void deletePlanetById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.remove(planet);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("It is impossible to delete a planet with this ID");
        }
    }

    public void updatePlanetById(String id, String newName) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            planet.setName(newName);
            session.merge(planet);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("A planet with this ID cannot be updated");
        }
    }

    public List<Planet> getPlanetAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Planet ", Planet.class).list();
        } catch (Exception ex) {
            System.err.println("Planet base is empty");
            return null;
        }
    }
}
