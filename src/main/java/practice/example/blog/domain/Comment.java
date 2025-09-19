/*
package com.example.blog.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "body", nullable = false)
  private String body;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "article_id")
  @JsonBackReference
  private Article article;

  @CreatedDate
  @Column(name = "created_cm", nullable = false)
  private LocalDateTime createdCm;

  public Comment(String body, Article article) {
    this.body = body;
    this.article = article;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
*/
