package day12.assignment.dto;

import day12.assignment.domain.Order;
import day12.assignment.domain.Product;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderDetailDto {
  private Long id;
  private String name;
  private String deliveryAddress;
  private List<String> products;

  public static OrderDetailDto from(Order order) {
    return OrderDetailDto.builder()
        .id(order.getId())
        .name(order.getName())
        .deliveryAddress(order.getDelivery().getAddress())
        .products(order.getProducts().stream()
            .map(Product::getName)
            .toList())
        .build();
  }
}