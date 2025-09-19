/*
package com.example.blog.controller;

import com.example.blog.DTO.AddArticleRequest;
import com.example.blog.DTO.ArticleResponse;
import com.example.blog.DTO.UpdateArticleRequest;
import com.example.blog.domain.Article;
import com.example.blog.service.BlogService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController    // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogController {
  private final BlogService blogService;

  public BlogController(BlogService blogService) {
    this.blogService = blogService;
  }


  // /api → 이 경로는 프론트엔드와 통신하는 API용이라는 의미로 사용되곤 함
  // HTTP요청이 'POST /api/articles' 경로일 때 해당 메소드로 매핑
  @PostMapping("/api/articles")
  public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) { // RequestBody로 요청 본문 값 매핑
    Article savedArticle = blogService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(savedArticle);
  }
  @GetMapping("/api/articles")
  public ResponseEntity<List<ArticleResponse>> findAllArticles() {
    List<ArticleResponse> list = blogService.findAll()
        .stream().map(article -> new ArticleResponse(article)) // Article → ArticleResponse
        .toList();
    return ResponseEntity.status(HttpStatus.OK)
        .body(list);
  }

  @DeleteMapping("/api/articles/{id}")
  public ResponseEntity<Void> deleteArticles(@PathVariable Long id) {
    blogService.delete(id);
    return ResponseEntity.ok().build();
  }
  @DeleteMapping("/api/articles/all")
  public ResponseEntity<Void> deleteAllArticles() {
    blogService.deleteAll();
    return ResponseEntity.ok().build();
  }

  @PutMapping("/api/articles/{id}")
  public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
    Article updatedArticle = blogService.update(id, request);
    return ResponseEntity.status(HttpStatus.OK)
        .body(updatedArticle);
  }



}
*/
