package crudservice;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDateTime;
import java.util.List;

public class TicketCrudService {
    public Ticket getTicketById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception ex) {
            System.err.println("Ticket id is empty");
            return null;
        }
    }

    public int createTicket(Client client, LocalDateTime createdAt, Planet fromPlanet, Planet toPlanet) {


        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = new Ticket();
            ticket.setClient(client);
            ticket.setCreatedAt(createdAt);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);
            session.persist(ticket);
            transaction.commit();
            return ticket.getId();
        } catch (Exception ex) {
            System.err.println("Ticket not created");
            return -1;
        }
    }

    public void deleteTicketById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            session.remove(ticket);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("It is impossible to delete a ticket with this ID");
        }
    }

    public void updateTicketById(int id, LocalDateTime createdAt, Client client, Planet fromPlanet, Planet toPlanet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            ticket.setCreatedAt(createdAt);
            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);
            session.merge(ticket);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("A ticket with this ID cannot be updated");
        }
    }

    public List<Ticket> getTicketAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket ", Ticket.class).list();
        } catch (Exception ex) {
            System.err.println("Ticket base is empty");
            return null;
        }
    }
}
