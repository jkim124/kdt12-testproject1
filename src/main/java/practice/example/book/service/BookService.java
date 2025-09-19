package practice.example.book.service;

import practice.example.book.domain.Book;
import practice.example.book.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getBookAll() {
    return bookRepository.findAll();
  }

  public Book getBookById(String id) {
    Optional<Book> book = bookRepository.findById(id);
    return book.orElse(null);
  }

  public Book addBook(Book book) {
    Book savedBook = new Book(book.getId(), book.getName(), book.getAuthor());
    return bookRepository.save(savedBook);
  }
}
