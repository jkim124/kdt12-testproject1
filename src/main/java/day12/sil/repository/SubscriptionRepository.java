package day12.sil.repository;

import day12.sil.domain.Subscription;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
  Optional<Object> findByName(String name);
  List<Subscription> findAllByMemberIsNotNull();
}
