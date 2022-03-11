package operasales.services.interfaces;

import operasales.events.Premiere;

public interface PremiereService {

    void addPremiere(String title, String description, int ageCategory, int seatsLimit, int tickets);

    void editPremiere(String title, Premiere premiere);

    void showPremiere(String title);

    void showAllPremieres();

    void deletePremiere();
}
