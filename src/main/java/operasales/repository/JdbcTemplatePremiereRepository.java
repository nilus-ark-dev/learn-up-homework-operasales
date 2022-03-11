package operasales.repository;

import operasales.events.Premiere;
import operasales.repository.interfaces.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcTemplatePremiereRepository implements PremiereRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcTemplatePremiereRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Premiere> getAll() {
        final String sql = "SELECT * FROM premieres;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql);

        List<Premiere> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(parse(sqlRowSet));
        }
        return result;
    }

    @Override
    public Premiere get(String title) {
        final String sql = "SELECT * FROM premieres WHERE title = ?;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql, title);

        sqlRowSet.next();
        return parse(sqlRowSet);
    }

    @Override
    public boolean save(Premiere premiere) {
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
    }

    private static Premiere parse(SqlRowSet result) {
        final String title = result.getString("title");
        final String description = result.getString("description");
        final int age_category = result.getInt("age_category");
        final int seats_limit = result.getInt("seats_limit");
        final int tickets = result.getInt("tickets");
        return new Premiere(title, description, age_category, seats_limit, tickets);
    }
}
