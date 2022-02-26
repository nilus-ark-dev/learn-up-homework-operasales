package operasales.services;

import lombok.AllArgsConstructor;
import operasales.events.Premiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PremiereService {

    private ConsoleLogger logger;

    @Autowired
    public PremiereService(ConsoleLogger logger) {
        this.logger = logger;
    }

    private Premiere premiere;

    HashMap<String, Premiere> premiereHashMap = new HashMap<>();

    public void addPremiere(String title, String description, int ageCategory, int seatsLimit, int tickets) {
        premiere = new Premiere(title, description, ageCategory, seatsLimit, tickets);
        premiereHashMap.put(premiere.getTitle(), premiere);
    }

    public void editPremiere(String title, Premiere premiere) {
        premiereHashMap.replace(title, premiere);
        logger.log("Премьера " + title + " была изменена\n");
    }

    public void showPremiere(String title) {
        logger.log(premiereHashMap.get(title));
    }

    public void showAllPremieres() {
        logger.log("Афиша премьер:\n");
        for (Map.Entry<String, Premiere> entry : premiereHashMap.entrySet()) logger.log(entry.getKey() + "\n");
    }

    public void deletePremiere(String title) {
        premiereHashMap.remove(title);
        logger.log("Премьера: " + title + " была удалена из расписания мероприятий!\n");
    }
}
