package operasales.repository;

import operasales.events.Premiere;
import operasales.repository.interfaces.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("jdbc")
public class JdbcTemplatePremiereRepository /*implements PremiereRepository*/ {

    private final JdbcTemplate jdbc;
    private TransactionTemplate txTemplate;

    @Autowired
    public JdbcTemplatePremiereRepository(JdbcTemplate jdbc, TransactionTemplate txTemplate) {
        this.jdbc = jdbc;
        this.txTemplate = txTemplate;
    }

    //@Override
    public List<Premiere> getAll() {
        final String sql = "SELECT * FROM premieres;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql);

        List<Premiere> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(parse(sqlRowSet));
        }
        return result;
    }

    //@Override
    public Premiere get(String title) {
        final String sql = "SELECT * FROM premieres WHERE title = ?;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql, title);

        sqlRowSet.next();
        return parse(sqlRowSet);
    }

    //@Override
    /*public boolean save(Premiere premiere) {
        final String sql = "INSERT INTO premieres (" +
                "title, " +
                "description, " +
                "age_category, " +
                "seats_limit, " +
                "tickets" +
        ") VALUES(?, ?, ?, ?, ?);";
        final int updatedRows = jdbc.update(
                sql,
                premiere.getTitle(),
                premiere.getDescription(),
                premiere.getAgeCategory(),
                premiere.getSeatsLimit(),
                premiere.getTickets()
        );
        return updatedRows == 1;
    }*/

    public boolean updateId(Premiere premiere) {
        final String sql = "UPDATE premieres SET id = ? WHERE title = ?;";
        final int updatedRows =
                jdbc.update(sql, premiere.getId(), premiere.getTitle());
        return updatedRows == 1;
    }

    private static Premiere parse(SqlRowSet result) {
        final String title = result.getString("title");
        final String description = result.getString("description");
        final int age_category = result.getInt("age_category");
        final int seats_limit = result.getInt("seats_limit");
        final int tickets = result.getInt("tickets");
        final int id = result.getInt("id");
        return new Premiere(title, description, age_category, seats_limit, tickets, id);
    }
}
