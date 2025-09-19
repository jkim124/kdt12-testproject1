/*
package com.example.blog.DTO;


import com.example.blog.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {
  private Long commentId;
  private Long articleId;
  private String body;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;
  private ArticleViewResponse article;

  @Getter
  @AllArgsConstructor
  public static class ArticleViewResponse {

    private Long articleId;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    }

    public CommentResponse(Comment comment) {
    this.commentId = comment.getId();
    this.articleId = comment.getArticle().getId();
    this.body = comment.getBody();
    this.createdAt = comment.getCreatedCm();
    this.article = new ArticleViewResponse(
        comment.getArticle().getId(),
        comment.getArticle().getTitle(),
        comment.getArticle().getContent(),
        comment.getArticle().getCreatedAt(),
        comment.getArticle().getUpdatedAt()
    );
    }
  }

*/
