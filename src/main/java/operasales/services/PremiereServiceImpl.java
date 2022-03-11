package operasales.services;

import operasales.events.Premiere;
import operasales.repository.interfaces.PremiereRepository;
import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.String;

@Service
//@AllArgsConstructor
public class PremiereServiceImpl implements PremiereService {

    private ConsoleLogger logger;

    private PremiereRepository premiereRepository;

    @Autowired
    public PremiereServiceImpl(ConsoleLogger logger, PremiereRepository premiereRepository) {
        this.logger = logger;
        this.premiereRepository = premiereRepository;
    }

    @Override
    public void addPremiere(String title, String description, int ageCategory, int seatsLimit, int tickets) {
        Premiere premiere = new Premiere(title, description, ageCategory, seatsLimit, tickets);
        premiereRepository.save(premiere);
    }

    @Override
    public void editPremiere(String title, Premiere premiere) {
        //
    }

    @Override
    public void showPremiere(String title) {
        logger.log(premiereRepository.get(title));
    }

    @Override
    public void showAllPremieres() {
        logger.log("Афиша премьер:\n");
        for (Premiere premiere : premiereRepository.getAll()) {
            logger.log(premiere.getTitle());
        }
    }

    @Override
    public void deletePremiere() {
        //
    }
}
