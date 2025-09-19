package practice.example.budget.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Budget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "amount", nullable = false)
  private int amount;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Builder
  public Budget(String title, int  amount, LocalDate date) {
    this.title = title;
    this.amount = amount;
    this.date = date;
  }

  public void update(String title, int amount, LocalDate date) {
    this.title = title;
    this.amount = amount;
    this.date = date;
  }
}
