package day12.assignment.dto;

import day12.assignment.domain.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderDto {
  private Long id;
  private String name;

  public static OrderDto from(Order order) {
    return OrderDto.builder()
        .id(order.getId())
        .name(order.getName())
        .build();
  }
}