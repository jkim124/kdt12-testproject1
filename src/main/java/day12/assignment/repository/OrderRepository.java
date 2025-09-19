package day12.assignment.repository;

import day12.assignment.domain.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("select distinct o from Order o " +
      "join fetch o.products p " +
      "join fetch o.delivery d")
  List<Order> findAllProductsDelivery();

  @Query("select o from Order o " +
      "join fetch o.products p " +
      "join fetch o.delivery d " +
      "where o.id = :id")
  Order findByIdProductsDelivery(Long id);
}

