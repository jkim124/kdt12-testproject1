/*
package com.example.blog.DTO;


import com.example.blog.domain.Article;
import com.example.blog.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AllResponse {

  private Long id;
  private String title;
  private String content;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updatedAt;

  private List<ArticleCommentResponse> comments;

  public AllResponse(Article article) {
    this.id = article.getId();
    this.title = article.getTitle();
    this.content = article.getContent();
    this.createdAt = article.getCreatedAt();
    this.updatedAt = article.getUpdatedAt();

    this.comments = article.getComments().stream()
        .map(ArticleCommentResponse::new)
        .collect(Collectors.toList());
  }

  @Getter
  public static class ArticleCommentResponse {
    private Long commentId;
    private String body;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public ArticleCommentResponse(Comment comment) {
      this.commentId = comment.getId();
      this.body = comment.getBody();
      this.createdAt = comment.getCreatedCm();
    }
  }
}*/
