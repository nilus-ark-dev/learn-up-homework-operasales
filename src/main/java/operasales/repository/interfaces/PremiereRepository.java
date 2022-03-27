package operasales.repository.interfaces;

import operasales.events.Premiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PremiereRepository extends JpaRepository<Premiere, String> {

    /*List<Premiere> getAll();

    Premiere get(String title);

    // Premiere set(String title, Premiere premiere);

    boolean save(Premiere premiere);*/
}
