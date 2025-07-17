package pl.coderslab;

public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String authro;
    private String publisher;
    private String type;

    // bezargumentowy konstruktor dla Jacksona
    public Book() {
    }

    public Book(Long id, String isbn, String title, String author, String publisher, String type) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authro = author;
        this.publisher = publisher;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return authro;
    }

    public void setAuthor(String authro) {
        this.authro = authro;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
