package operasales.services.interfaces;

import operasales.events.Premiere;

public interface PremiereService {

    void addPremiere(String title, String description, int ageCategory, int seatsLimit, int tickets, int id);

    void updateAllId(int targetId);

    void editPremiere(String title, Premiere premiere);

    void printCount();

    void printAllPremieresByPattern(String pattern);

    void showPremiere(String title);

    void showAllPremieres();

    void deletePremiere();
}
