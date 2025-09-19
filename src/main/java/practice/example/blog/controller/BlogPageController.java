/*
package com.example.blog.controller;

import com.example.blog.DTO.AddArticleRequest;
import com.example.blog.DTO.AddCommentRequest;
import com.example.blog.DTO.AllResponse;
import com.example.blog.DTO.ArticleViewResponse;
import com.example.blog.DTO.CommentResponse;
import com.example.blog.DTO.UpdateArticleRequest;
import com.example.blog.DTO.UpdateCommentRequest;
import com.example.blog.domain.Article;
import com.example.blog.domain.Comment;
import com.example.blog.service.BlogService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogPageController {
  private BlogService blogService;

  public BlogPageController(BlogService blogService) {
    this.blogService = blogService;
  }

  @GetMapping("/articles")
  public String getArticles(Model model) {
    List<ArticleViewResponse> articles = blogService.findAll()
        .stream()
        .map(ArticleViewResponse::new)
        .toList();
    model.addAttribute("articles", articles);

    return "articleList";
  }

  @GetMapping("/articles/{id}")
  public String showArticle(@PathVariable Long id, Model model) {
    AllResponse allResponse = blogService.getAll(id);

    model.addAttribute("article", allResponse);

    return "article";
  }




@PostMapping("/api/articles")
public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
    Article savearticle = blogService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(savearticle);
}

  @PutMapping("/api/articles/{id}")
  public ResponseEntity<Article> updateAticle (@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
    Article updateArticle = blogService.update(id, request);
    return ResponseEntity.status(HttpStatus.OK)
        .body(updateArticle);
  }



  @DeleteMapping("/api/articles/{id}")
  public ResponseEntity<Void> delArticle(@PathVariable Long id) {
    blogService.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/new-article")
  public String newArticle(@RequestParam(required = false) Long id, Model model) {
    if (id == null) {
      model.addAttribute("article", new ArticleViewResponse());
    } else {
      Article article = blogService.findById(id);
      model.addAttribute("article", new ArticleViewResponse(article));
    }
    return "newArticle";
  }
//comments
  @PostMapping("/api/articles/{articleId}/comments")
  public ResponseEntity<CommentResponse> addComment(@PathVariable("articleId") Long articleId,@RequestBody AddCommentRequest request) {
    Comment saveComment = blogService.savecm(articleId,request);
    CommentResponse commentResponse = new CommentResponse(saveComment);
    return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
  }

  @GetMapping("/api/comments/{commentId}")
  public ResponseEntity<CommentResponse> getComments(@PathVariable Long commentId) {
    return ResponseEntity.ok(blogService.getComment(commentId));
  }

  @PutMapping("/api/comments/{commentId}")
  public ResponseEntity<CommentResponse> updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request) {
  CommentResponse update = blogService.updatecomment(commentId, request);
  return ResponseEntity.ok(update);
  }

  @DeleteMapping("/api/comments/{commentId}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
    blogService.deleteComment(commentId);
    return  ResponseEntity.ok().build();
  }
  @GetMapping("/api/articles/{articleId}/comments")
  public ResponseEntity<AllResponse> getAllcomments(
      @PathVariable Long articleId) {

    AllResponse response = blogService.getAll(articleId);
    return ResponseEntity.ok(response);
  }
}*/
