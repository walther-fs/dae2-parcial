package parcial.isil.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import parcial.isil.model.Book;
import parcial.isil.repository.JdbcBookRepository;

@Slf4j
@Configuration
public class BookLoader implements CommandLineRunner {

    private final JdbcBookRepository jdbcBookRepository;

    public BookLoader(JdbcBookRepository jdbcBookRepository) {
        this.jdbcBookRepository = jdbcBookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Book book = new Book("8795462135821","ISIL","Walther Flores",2020,"Examen Parcial",27.59);
        jdbcBookRepository.save(book);
        log.info("book: {}", book);
    }
}
