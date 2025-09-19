package practice.example.budget.controller;

import practice.example.budget.DTO.AddBudgetRequest;
import practice.example.budget.DTO.BudgetResponse;
import practice.example.budget.DTO.UpdateBudgetRequest;
import practice.example.budget.domain.Budget;
import practice.example.budget.service.BudgetService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController {
  private BudgetService budgetService;

  public BudgetController(BudgetService budgetService) {
    this.budgetService = budgetService;
  }

  @PostMapping("/api/budget")
  public ResponseEntity<Budget> addBudget(@RequestBody AddBudgetRequest request) {
    Budget savedBudget = budgetService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedBudget);
  }

  @GetMapping("/api/budget")
  public ResponseEntity<List<BudgetResponse>> findAllBudgets() {
    List<BudgetResponse> list = budgetService.findAll()
        .stream().map(budget -> new BudgetResponse(budget))
        .toList();
    return ResponseEntity.status(HttpStatus.OK)
        .body(list);
  }

  @GetMapping("/api/budget/{id}")
  public ResponseEntity<BudgetResponse> findBudgetById(@PathVariable Long id) {
    Budget budget = budgetService.findBudgetById(id);
    BudgetResponse budgetResponse = new BudgetResponse(budget);
    return ResponseEntity.ok(budgetResponse);
  }

  @DeleteMapping("/api/budget")
  public ResponseEntity<Void> deleteAllBudget() {
    budgetService.deleteAll();
    return ResponseEntity.ok().build();
  }
  @DeleteMapping("/api/budget/{id}")
  public ResponseEntity<Void> deleteBudgetById(@PathVariable Long id) {
    budgetService.delete(id);
    return ResponseEntity.ok().build();
  }
  @PutMapping("/api/budget/{id}")
  public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody UpdateBudgetRequest request) {
    Budget updatedBudget = budgetService.update(id, request);
    return ResponseEntity.status(HttpStatus.OK)
        .body(updatedBudget);
  }
}