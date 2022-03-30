package operasales.repository.interfaces;

import operasales.events.Premiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PremiereRepository extends JpaRepository<Premiere, String> {

    @Query("select count(premiere) from Premiere premiere")
    int countAllPremieres();

    @Query("from Premiere premiere where premiere.title like :pattern or premiere.description like :pattern")
    List<Premiere> getAllPremieresWhichHasPattern(String pattern);

    //List<Premiere> getAll();

    //Premiere get(String title);

    @Modifying
    @Query("update Premiere p set p.id = :id where p.title = :title")
    void updateId(int id, String title);

    // Premiere set(String title, Premiere premiere);

    //boolean save(Premiere premiere);
}
