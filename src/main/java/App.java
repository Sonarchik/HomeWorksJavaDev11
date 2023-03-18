import crudservice.ClientCrudService;
import crudservice.PlanetCrudService;
import crudservice.TicketCrudService;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();
        clientCrudService.createClient("Anatoliy Permission");
        System.out.println(clientCrudService.getClientAll());
        clientCrudService.deleteClientById(11);
        System.out.println(clientCrudService.getClientById(3));
        clientCrudService.updateById(3, "New Name");
        System.out.println(clientCrudService.getClientAll());
        planetCrudService.createPlanet("PMO46", "UKROPIAY");
        System.out.println(planetCrudService.getPlanetAll());
        planetCrudService.updatePlanetById("PMO46", "UKRAINE");
        System.out.println(planetCrudService.getPlanetAll());
        System.out.println(planetCrudService.getPlanetById("PMO46"));
        planetCrudService.deletePlanetById("PMO46");
        System.out.println(planetCrudService.getPlanetAll());
        System.out.println(ticketCrudService.getTicketAll());
        System.out.println(ticketCrudService.getTicketById(2));
        ticketCrudService.updateTicketById(1,
                LocalDateTime.of(2045, 10, 23, 15, 43, 24),
                clientCrudService.getClientById(2),
                planetCrudService.getPlanetById("MARS6"),
                planetCrudService.getPlanetById("VEN"));
        System.out.println(ticketCrudService.getTicketById(1));
        System.out.println(ticketCrudService.createTicket(clientCrudService.getClientById(6),
                LocalDateTime.of(2435, 10, 23, 15, 43, 24),
                planetCrudService.getPlanetById("VEN"),
                planetCrudService.getPlanetById("JUP238")));
        System.out.println(ticketCrudService.getTicketAll());
        ticketCrudService.deleteTicketById(1);
    }
}
