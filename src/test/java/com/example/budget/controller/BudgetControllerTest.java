package com.example.budget.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import practice.example.budget.DTO.UpdateBudgetRequest;
import practice.example.budget.domain.Budget;
import practice.example.budget.repository.BudgetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class BudgetControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private BudgetRepository budgetRepository;

  @BeforeEach
  public void mockMvcSetUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    budgetRepository.deleteAll();
  }

  @DisplayName("가계부 전체 조회 성공")
  @Test
  public void testFindAll() throws Exception {
    // given
    final String url = "/api/budget";
    final String title = "제목";
    final int amount = 1;
    final LocalDate date = LocalDate.now();
    Budget budget = budgetRepository.save(new Budget(title, amount, date));

    // when
    ResultActions result = mockMvc.perform(get(url));

    // then : 정상적으로 요청이 되었는지 검증
    result.andExpect(status().isOk())
        .andExpect(jsonPath("$[0].title").value(budget.getTitle()))
        .andExpect(jsonPath("$[0].amount").value(budget.getAmount()))
        .andExpect(jsonPath("$[0].date").value(budget.getDate().toString()));
  }

  @DisplayName("가계부 단건 조회 성공")
  @Test
  public void findBudgetById() throws Exception {
    // given: 테스트용 데이터
    Budget budget = Budget.builder()
        .title("단 건 테스트")
        .amount(1)
        .date(LocalDate.parse("2025-09-04"))
        .build();
    budgetRepository.save(budget);

    Long budgetId = budget.getId();

    // when : 저장된 id 값으로 GET
    ResultActions resultActions = mockMvc.perform(get("/api/budget/{id}", budgetId));

    // then : 저장한 값하고 일치하는 지 확인
    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value(budget.getTitle()))
        .andExpect(jsonPath("$.amount").value(budget.getAmount()))
        .andExpect(jsonPath("$.date").value(budget.getDate().toString()));
  }

  @DisplayName("가계부 단건 삭제 성공")
  @Test
  public void testDeleteBudget() throws Exception {
    // given
    final String url = "/api/budget/{id}";
    String title = "제목1";
    int amount = 1;
    LocalDate date = LocalDate.now();

    Budget budget = budgetRepository.save(new Budget(title, amount, date));
    Long savedId = budget.getId();

    // when
    mockMvc.perform(delete(url, savedId))
        .andExpect(status().isOk());

    // then
    assertThat(budgetRepository.findById(savedId).isEmpty());
  }

@DisplayName("가계부 전체 삭제 성공")
@Test
public void testDeleteAllBudget() throws Exception {
  // given
  final String url = "/api/budget";

  Budget budget = budgetRepository.save(new Budget("제목1", 1,LocalDate.now()));
  Budget budget2 = budgetRepository.save(new Budget("제목2", 2,LocalDate.now()));

  // when
  mockMvc.perform(delete(url)).andExpect(status().isOk());

  // then
  List<Budget> afterDeleteList = budgetRepository.findAll();
  assertThat(afterDeleteList).isEmpty();
}

  @DisplayName("가계부 수정 성공")
  @Test
  public void updateBudget() throws Exception {
    // given
    String url = "/api/budget/{id}";
    String title = "제목";
    int amount = 1;
    LocalDate date = LocalDate.now();
    Budget budget = budgetRepository.save(new Budget(title, amount, date));

    String modifiedTitle = "제목수정";
    int modifiedamount = 2;
    LocalDate modifieddate = LocalDate.now();
    UpdateBudgetRequest request = new UpdateBudgetRequest(modifiedTitle, modifiedamount,modifieddate);

    // when
    ResultActions result = mockMvc.perform(put(url, budget.getId())
        .content(objectMapper.writeValueAsString(request))
        .contentType(MediaType.APPLICATION_JSON_VALUE));

    // then
    result.andExpect(status().isOk());

    Budget afterModifiedBudget = budgetRepository.findById(budget.getId())
        .orElseThrow(() -> new IllegalArgumentException());
    assertThat(afterModifiedBudget.getTitle()).isEqualTo(modifiedTitle);
    assertThat(afterModifiedBudget.getAmount()).isEqualTo(modifiedamount);
    assertThat(afterModifiedBudget.getDate()).isEqualTo(modifieddate);
  }
}