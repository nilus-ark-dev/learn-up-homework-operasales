package operasales.repository.interfaces;

import operasales.events.Premiere;

import java.util.List;

public interface PremiereRepository {

    List<Premiere> getAll();

    Premiere get(String title);

    // Premiere set(String title, Premiere premiere);

    boolean save(Premiere premiere);
}
