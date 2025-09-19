package day12.assignment.controller;

import day12.assignment.dto.OrderDetailDto;
import day12.assignment.dto.OrderDto;
import day12.assignment.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public List<OrderDto> getOrders() {
    return orderService.getOrders();
  }

  @GetMapping("/{id}")
  public OrderDetailDto getOrderDetail(@PathVariable Long id) {
    return orderService.getOrderDetail(id);
  }
}