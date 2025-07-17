package pl.coderslab.service;


import org.springframework.stereotype.Service;
import pl.coderslab.Book;
import pl.coderslab.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {
    private List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return this.list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return this.list.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(Book book) {
        this.list.add(book);
    }

    @Override
    public void delete(Long id) {
        this.list.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void update(Book book) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(book.getId())) {
                list.set(i, book);
                return;
            }
        }
        throw new RuntimeException("Book not found with id: " + book.getId());
    }
}
