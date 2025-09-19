package practice.example.book.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Book {
  @Id
  @Column(name= "id", nullable = false)
  private String id;

  @Column(name= "name", nullable = false)
  private String name;

  @Column(name="author", nullable = false)
  private String author;

  @Builder
  public Book(String id, String name, String author) {
   this.id = id;
   this.name = name;
   this.author = author;
  }

}
