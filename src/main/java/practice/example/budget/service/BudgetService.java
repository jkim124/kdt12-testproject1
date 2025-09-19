package practice.example.budget.service;

import practice.example.budget.DTO.AddBudgetRequest;
import practice.example.budget.DTO.UpdateBudgetRequest;
import practice.example.budget.domain.Budget;
import practice.example.budget.repository.BudgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BudgetService {
  private BudgetRepository budgetRepository;

  public BudgetService(BudgetRepository budgetRepository) {
    this.budgetRepository = budgetRepository;
  }

  public Budget save(AddBudgetRequest request) {
    return budgetRepository.save(request.toEntity());
  }

  public List<Budget> findAll() {
    return budgetRepository.findAll();
  }

  public Budget findBudgetById(Long id) {
    Optional<Budget> optBudget = budgetRepository.findById(id);
    return optBudget.orElseGet(Budget::new);
  }



  public void delete(Long id) {
    budgetRepository.deleteById(id);
  }

  public void deleteAll() {
    budgetRepository.deleteAll();
  }

  @Transactional
  public Budget update(Long id, UpdateBudgetRequest request) {
    Budget budget = budgetRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    budget.update(request.getTitle(), request.getAmount(), request.getDate());
    return budget;
  }
}
