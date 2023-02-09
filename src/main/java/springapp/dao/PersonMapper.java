package springapp.dao;

import org.springframework.jdbc.core.RowMapper;
import springapp.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("person_id"));
        person.setName(rs.getString("full_name"));
        person.setYear(rs.getInt("year_of_birth"));

        return person;
    }
}
