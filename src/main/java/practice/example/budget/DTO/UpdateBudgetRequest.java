package practice.example.budget.DTO;

import java.time.LocalDate;

public class UpdateBudgetRequest {
  private String title;
  private int amount;
  private LocalDate date;

  public UpdateBudgetRequest(String title, int amount, LocalDate date) {
    this.title = title;
    this.amount = amount;
    this.date = date;
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
