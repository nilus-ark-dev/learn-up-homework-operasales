/*package operasales.services;

import operasales.annotations.Notifiable;
import operasales.events.Premiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
*/
/*
@Service
public class TicketService {

    private final ConsoleLogger logger;

    //@Autowired
    private final PremiereServiceImpl premiereService;

    @Autowired
    public TicketService(ConsoleLogger logger, PremiereServiceImpl premiereService) {
        this.logger = logger;
        this.premiereService = premiereService;
    }

    //@Notifiable
    public void buyTicket(String title) {
        if (premiereService.premiereHashMap.containsKey(title)) {
            Premiere premiere = premiereService.premiereHashMap.get(title);
            if (premiere.getTickets() > 0) {
                premiere.setTickets(premiere.getTickets() - 1);
                premiereService.premiereHashMap.put(title, premiere);
                logger.log("Куплен билет на премьеру " + title  + " (осталось " + premiere.getTickets() + ")\n");
            } else {
                logger.log("Билеты закончились\n");
            }
        } else {
            logger.log("Введите корректное название премьеры!\n");
        }
    }

    public void returnTicket(String title) {
        if (premiereService.premiereHashMap.containsKey(title)) {
            Premiere premiere = premiereService.premiereHashMap.get(title);
            premiere.setTickets(premiere.getTickets() + 1);
            premiereService.premiereHashMap.put(title, premiere);
            logger.log("Билет на премьеру " + title + " сдан" + " (осталось " + premiere.getTickets() + ")\n");
        } else {
            logger.log("Введите корректное название премьеры!\n");
        }
    }

}*/
