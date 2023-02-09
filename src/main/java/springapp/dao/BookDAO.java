package springapp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import springapp.models.Book;
import springapp.models.Person;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE id = ?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Book.class)).
                stream().findAny().orElse(null);
    }

    public Person hasTaken(int id){
        return jdbcTemplate.query("SELECT * FROM Person JOIN Book b ON Person.person_id = b.person_id WHERE id = ?",
                new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
    }

    public void free(int id){
        jdbcTemplate.update("UPDATE BOOK SET person_id = null WHERE id = ?", id);
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(title, author, year) VALUES (?, ?, ?)", book.getTitle(),
                book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updateBook){
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=? WHERE id=?", updateBook.getTitle(),
                updateBook.getAuthor(), updateBook.getYear(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public void assignBook(int id, Person person){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id = ?", person.getId(), id);
    }
}
