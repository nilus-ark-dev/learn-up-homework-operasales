package operasales.services;

import operasales.domain.PremiereMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class TicketService {

    private final ConsoleLogger logger;

    private final PremiereServiceImpl premiereService;

    @Autowired
    public TicketService(ConsoleLogger logger, PremiereServiceImpl premiereService) {
        this.logger = logger;
        this.premiereService = premiereService;
    }

    @PreAuthorize("hasRole(\"USER\")")
    public void buyTicket(String title) {
        if (premiereService.premiereMainCollection.containsKey(title)) {
            PremiereMain premiere = premiereService.premiereMainCollection.get(title);
            if (premiere.getTickets() > 0) {
                premiere.setTickets(premiere.getTickets() - 1);
                premiereService.premiereMainCollection.put(title, premiere);
                logger.log("Куплен билет на премьеру " + title  + " (осталось " + premiere.getTickets() + ")\n");
            } else {
                logger.log("Билеты закончились\n");
            }
        } else {
            logger.log("Введите корректное название премьеры!\n");
        }
    }

    @PreAuthorize("hasRole(\"USER\")")
    public void returnTicket(String title) {
        if (premiereService.premiereMainCollection.containsKey(title)) {
            PremiereMain premiere = premiereService.premiereMainCollection.get(title);
            premiere.setTickets(premiere.getTickets() + 1);
            premiereService.premiereMainCollection.put(title, premiere);
            logger.log("Билет на премьеру " + title + " сдан" + " (осталось " + premiere.getTickets() + ")\n");
        } else {
            logger.log("Введите корректное название премьеры!\n");
        }
    }
}
