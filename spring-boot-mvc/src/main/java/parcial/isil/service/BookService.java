package parcial.isil.service;

import org.springframework.stereotype.Service;
import parcial.isil.model.Book;
import parcial.isil.repository.JdbcBookRepository;

import java.util.List;

@Service
public class BookService implements BaseService<Book,String> {

    private final JdbcBookRepository jdbcBookRepository;

    public BookService(JdbcBookRepository jdbcBookRepository) {
        this.jdbcBookRepository = jdbcBookRepository;
    }

    @Override
    public Book save(Book book) {
        jdbcBookRepository.save(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        jdbcBookRepository.update(book);
        return book;
    }

    @Override
    public void delete(String isbn) {
        jdbcBookRepository.delete(isbn);
    }

    @Override
    public List<Book> findAll() {
        return jdbcBookRepository.getAll();
    }

    @Override
    public Book findById(String isbn) {
        return jdbcBookRepository.getById(isbn);
    }
}
