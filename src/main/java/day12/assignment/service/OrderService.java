package day12.assignment.service;

import day12.assignment.domain.Order;
import day12.assignment.domain.Product;
import day12.assignment.dto.OrderDetailDto;
import day12.assignment.dto.OrderDto;
import day12.assignment.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
  @RequiredArgsConstructor
  public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> getOrders() {
      return orderRepository.findAllProductsDelivery()
          .stream()
          .map(OrderDto::from)
          .toList();
    }

    @Transactional(readOnly = true)
    public OrderDetailDto getOrderDetail(Long orderId) {
      Order order = orderRepository.findByIdProductsDelivery(orderId);
      return OrderDetailDto.from(order);
    }
  }
