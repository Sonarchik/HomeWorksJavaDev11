package crudservice;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ClientCrudService {

    public List<Client> getClientAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        } catch (Exception ex) {
            System.err.println("Client base is empty");
            return null;
        }
    }

    public Client getClientById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        } catch (Exception ex) {
            System.err.println("Client id is empty");
            return null;
        }
    }

    public void createClient(String name) {
        Client client = new Client();
        client.setName(name);

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Client not created");
        }
    }

    public void deleteClientById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.remove(client);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("It is impossible to delete a client with this ID");
        }
    }

    public void updateById(int id, String newName) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            client.setName(newName);
            session.merge(client);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("A client with this ID cannot be updated");
        }
    }
}
