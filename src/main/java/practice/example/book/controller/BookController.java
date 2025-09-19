/*
package com.example.book.controller;

import com.example.book.DTO.PostContent;
import com.example.book.domain.Book;
import com.example.book.service.BookService;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Controller
public class BookController {
  private BookService bookService;


  public BookController(BookService bookService) {
    this.bookService = bookService;
  }




  @GetMapping("/books")
  public String home(Model model) {
    List<Book> memberList = bookService.getBookAll();
    model.addAttribute("bookList", memberList);
    return "bookManage";
  }
  @GetMapping("/books/{id}")
  public String view(@PathVariable String id, Model model) {
    Book book = bookService.getBookById(id);
    model.addAttribute("book", book);
    return "bookDetail";
  }

  @PostMapping("/books")
  public String add(@RequestParam String id,
      @RequestParam String name,
      @RequestParam String author,
      Model model) {
    Book book = Book.builder()
        .id(id)
        .name(name)
        .author(author)
        .build();
    bookService.addBook(book);
    return "redirect:/books";
  }

  @GetMapping("/api/external")
  public ResponseEntity<String> externalApiSave() {
    externalService.save();
    return ResponseEntity.ok("외부 API 데이터 저장 완료");
  }

  public void save() {
    String url = "https://jsonplaceholder.typicode.com/posts";

    RestTemplate restTemplate = new RestTemplate(); // 스프링에서 관리해서 의존성 주입으로 사용해도 됨.
    ResponseEntity<List<PostContent>> response = restTemplate.exchange(
        url, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<PostContent>>() {}
    );


    List<PostContent> books = response.getBody();
    // log.info("데이터 개수: {}", books.size());

    // Entity로 변환해서 저장
    for (PostContent dto : books) {
      log.info("title: {}, content: {}", dto.getTitle(), dto.getBody());

      AddBookRequest request = new AddBookRequest(
          String.valueOf(dto.getId()),
          dto.getTitle(),
          String.valueOf(dto.getUserId())
      );

      Book book = request.toEntity();

      bookRepository.save(book);
    }
  }

}

*/

