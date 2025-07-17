package pl.coderslab.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping(value = "/helloBook", produces = "application/json")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> getBooks() {
        return mockBookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id){
        return mockBookService.get(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        if (book.getId() == null) {
            book.setId((long) (mockBookService.getBooks().size() + 1));
        }
        mockBookService.add(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book){
        if (book.getId() == null) {
            throw new RuntimeException("Book id must not be null for update");
        }
        mockBookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        mockBookService.get(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        mockBookService.delete(id);
    }
}
