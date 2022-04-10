package operasales.repository.interfaces;

import operasales.events.Premiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PremiereRepository extends JpaRepository<Premiere, String> {

    @Query("select count(premiere) from Premiere premiere")
    int countAllPremieres();

    @Query("from Premiere p where p.title like :pattern or p.description like :pattern")
    List<Premiere> getAllPremieresWhichHasPattern(String pattern);

    @Modifying
    @Query("update Premiere p set p.id = :id where p.title = :title")
    void updateId(int id, String title);


    @Query("from Premiere p where p.title = :title")
    Premiere get(String title);

    @Query("from Premiere p where p.id = :id")
    void delete(int id);
}
