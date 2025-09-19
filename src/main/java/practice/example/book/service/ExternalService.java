/*
package com.example.book.service;

import com.example.book.DTO.PostContent;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ExternalService {
  public void call() {
    String url = "https://jsonplaceholder.typicode.com/posts";

    // RestTemplate
    RestTemplate restTemplate = new RestTemplate(); // 스프링에서 관리해서 의존성 주입으로 사용해도 됨.
    ResponseEntity<List<PostContent>> response = restTemplate.exchange(url, HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {});

    log.info("code: {}", response.getStatusCode()); // 200
    List<PostContent> postContent = response.getBody();
    log.info("postContent: {}", postContent); // id가 여러개
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
