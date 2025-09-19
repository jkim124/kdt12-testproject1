/*
package com.example.blog.service;

import com.example.blog.DTO.AddArticleRequest;
import com.example.blog.DTO.AddCommentRequest;
import com.example.blog.DTO.AllResponse;
import com.example.blog.DTO.CommentResponse;
import com.example.blog.DTO.UpdateArticleRequest;
import com.example.blog.DTO.UpdateCommentRequest;
import com.example.blog.domain.Article;
import com.example.blog.domain.Comment;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.CommentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

  private final BlogRepository blogRepository;
  private final CommentRepository commentRepository;

  public BlogService(BlogRepository blogRepository, CommentRepository commentRepository) {
    this.blogRepository = blogRepository;
    this.commentRepository = commentRepository;
  }


  public Article save(AddArticleRequest request) {
    Article article = new Article(request.getTitle(), request.getContent());
    return blogRepository.save(article);
  }

  public Comment savecm(Long id, AddCommentRequest request) {
    Article article = blogRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("not found article id=" + id));
    Comment comment = new Comment(request.getBody(),article);
    return commentRepository.save(comment);
  }

  public CommentResponse getComment(Long id)
  {
    Comment comment = commentRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("not found commentId=" + id));
    return new CommentResponse(comment);
  }



  public List<Article> findAll() {
    return blogRepository.findAll();
  }

  public Article findById(Long id){
    Optional<Article> optarticle = blogRepository.findById(id);
    return optarticle.orElseGet(Article::new);
  }



  public void delete(Long id) {
    blogRepository.deleteById(id);
  }


  public Article update(Long id, UpdateArticleRequest request) {
    Article article = blogRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found " + id)); // 500 Error
    article.update(request.getTitle(), request.getContent());
    return blogRepository.save(article);
  }

  public CommentResponse updatecomment(Long commentId, UpdateCommentRequest request) {
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new IllegalArgumentException("not found " + commentId));
    comment.setBody(request.getBody());
    Comment updatedcomment = commentRepository.save(comment);
    return new CommentResponse(updatedcomment);
  }
  public void deleteComment(Long commentId) {
    Comment comment = commentRepository.findById(commentId)
        .orElseThrow(() -> new IllegalArgumentException("not found " + commentId));
    commentRepository.delete(comment);
  }

  public AllResponse getAll(Long articleId) {
    Article article = blogRepository.findById(articleId)
        .orElseThrow(() -> new IllegalArgumentException("not found " + articleId));
    return new AllResponse(article);
  }
}*/
