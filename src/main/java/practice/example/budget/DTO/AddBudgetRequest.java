package practice.example.budget.DTO;

import practice.example.budget.domain.Budget;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBudgetRequest {
  private String title;
  private int amount;
  private LocalDate date;

  public Budget toEntity() {
    return Budget.builder()
        .title(title)
        .amount(amount)
        .date(date)
        .build();
  }
}