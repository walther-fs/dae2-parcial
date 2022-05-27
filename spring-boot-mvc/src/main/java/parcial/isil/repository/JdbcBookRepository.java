package parcial.isil.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import parcial.isil.model.Book;
import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(Book book) {
        final String SQL = "insert into books (isbn, publisherName, authorName, years, title, price) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, book.getIsbn(), book.getPublisherName(), book.getAuthorName(), book.getYears(),book.getTitle(),book.getPrice());
    }

    @Override
    public void update(Book book) {
        final String SQL = "UPDATE books SET publisherName=?, authorName=?, years=?, title=?, price=? WHERE isbn = ?";
        jdbcTemplate.update(SQL, book.getPublisherName(), book.getAuthorName(), book.getYears(),book.getTitle(),book.getPrice(),  book.getIsbn());
    }

    @Override
    public void delete(String isbn) {
        final String SQL = "DELETE books WHERE isbn = ?";
        jdbcTemplate.update(SQL, isbn);
    }

    @Override
    public List<Book> getAll() {
        final String SQL = "SELECT * FROM books";
        return jdbcTemplate.query(SQL, getBookRowMapper());
    }

    private RowMapper<Book> getBookRowMapper() {
        return (r, i) -> {
            String isbn = r.getString("isbn");
            String publisherName = r.getString("publisherName");
            String authorName = r.getString("authorName");
            Integer years = r.getInt("years");
            String title = r.getString("title");
            Double price = r.getDouble("price");
            return new Book(isbn, publisherName, authorName, years, title, price);
        };
    }

    @Override
    public Book getById(String isbn) {
        final String SQL = "SELECT * FROM books WHERE isbn = ?";
        return jdbcTemplate.queryForObject(SQL, getBookRowMapper(), isbn);
    }
}
