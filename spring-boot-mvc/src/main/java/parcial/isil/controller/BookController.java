package parcial.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import parcial.isil.model.Book;
import parcial.isil.service.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/books/add")
    public String bookAdd(Model model){
        model.addAttribute("book", new Book());
        return "books-add";
    }

    @PostMapping("/books/save")
    public String bookSave(Book book){
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{isbn}")
    public String bookEdit(@PathVariable String isbn, Model model){
        Book book = bookService.findById(isbn);
        model.addAttribute("book", book);
        return "books-edit";
    }

    @PostMapping("/books/update")
    public String bookUpdate(Book book){
        bookService.update(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{isbn}")
    public String bookDelete(@PathVariable String isbn){
        Book book = bookService.findById(isbn);
        bookService.delete(book.getIsbn());
        return "redirect:/books";
    }
}
