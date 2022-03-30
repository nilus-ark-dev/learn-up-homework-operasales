//package operasales.repository;

import operasales.events.Premiere;
/*import operasales.repository.interfaces.PremiereRepository;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.*;
/*
@Repository
@Profile("jdbc-named")
public class NPJdbcTemplatePremiereRepository implements PremiereRepository {

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public NPJdbcTemplatePremiereRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Premiere> getAll() {
        final String sql = "SELECT * FROM premieres;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql, Collections.emptyMap());

        List<Premiere> result = new ArrayList<>();
        while (sqlRowSet.next()) {
            result.add(parse(sqlRowSet));
        }
        return result;
    }

    @Override
    public Premiere get(String title) {
        final String sql = "SELECT * FROM premieres WHERE title = :title;";
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet(sql, Collections.singletonMap("title", title));

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
        ") VALUES(" +
                ":title, " +
                ":description, " +
                ":age_category, " +
                ":seats_limit, " +
                ":tickets);";
        Map<String, Object> params = new HashMap<String, Object>(){{
            put("title", premiere.getTitle());
            put("description", premiere.getDescription());
            put("age_category", premiere.getAgeCategory());
            put("seats_limit", premiere.getSeatsLimit());
            put("tickets", premiere.getTickets());
        }};
        final int updatedRows = jdbc.update(sql, params);
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
}*/
