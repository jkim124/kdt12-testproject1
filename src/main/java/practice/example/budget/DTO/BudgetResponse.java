
package practice.example.budget.DTO;

import practice.example.budget.domain.Budget;
import java.time.LocalDate;

public class BudgetResponse {
  private Long id;
  private String title;
  private int amount;
  private LocalDate date;


  public BudgetResponse(Budget budget) {
    this.title = budget.getTitle();
    this.amount = budget.getAmount();
    this.date = budget.getDate();
  }

  public String getTitle() {
    return title;
  }

  public int getAmount() {
    return amount;
  }

  public LocalDate getDate() {
    return date;
  }
}

