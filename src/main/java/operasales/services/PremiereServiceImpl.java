package operasales.services;

import operasales.events.Premiere;
//import operasales.repository.JdbcTemplatePremiereRepository;
import operasales.repository.interfaces.PremiereRepository;
import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.Collection;
import java.util.List;

@Service
public class PremiereServiceImpl implements PremiereService {

    private ConsoleLogger logger;

    private PremiereRepository premiereRepository;

    @Autowired
    public PremiereServiceImpl(ConsoleLogger logger, PremiereRepository premiereRepository) {
        this.logger = logger;
        this.premiereRepository = premiereRepository;
    }

    @Override
    public void addPremiere(String title, String description, int ageCategory, int seatsLimit, int tickets, int id) {
        Premiere premiere = new Premiere(title, description, ageCategory, seatsLimit, tickets, id);
        premiereRepository.save(premiere);
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            rollbackFor = {
                    EOFException.class
            },
            noRollbackFor = {
                    FileNotFoundException.class,
                    NullPointerException.class
            }
    )
    public void updateAllId(int targetId) {
        logger.log("Начало транзакции...");
        final List<Premiere> premieres = premiereRepository.findAll();
        for (Premiere premiere : premieres) {
            //premiere.setId(Integer.parseInt(targetId));
            premiereRepository.updateId(targetId, premiere.getTitle());
        }
        logger.log("Транзакция завершена!");
    }


    @Override
    public void editPremiere(String title, Premiere premiere) {
        //
    }

    @Override
    public void printCount() {
        logger.log(
                "Всего премьер: " + premiereRepository.countAllPremieres());
    }

    @Override
    public void printAllPremieresByPattern(String pattern) {
        for (Premiere premiere : premiereRepository.getAllPremieresWhichHasPattern(pattern)) {
            logger.log(premiere);
        }
    }

    @Override
    public void showPremiere(String title) {
        logger.log(premiereRepository.findById(title).get());
    }

    @Override
    public void showAllPremieres() {
        logger.log("Афиша премьер:");
        for (Premiere premiere : premiereRepository.findAll()) {
            logger.log(premiere.getTitle());
        }
    }

    @Override
    public void deletePremiere() {
        //
    }

    @Override
    public Collection<Premiere> getAll() {
        return premiereRepository.findAll();
    }
}
