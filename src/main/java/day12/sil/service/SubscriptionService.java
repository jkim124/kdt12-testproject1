package day12.sil.service;


import day12.sil.dto.SubscriptionResponseDto;
import day12.sil.repository.SubscriptionRepository;
import day12.sil.domain.Subscription;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SubscriptionRepository subscriptionRepository;

  public List<SubscriptionResponseDto> getAllSubscriptionsWithMembers() {
    return subscriptionRepository.findAllByMemberIsNotNull()
        .stream()
        .map(subscription -> {
          System.out.println("Before accessing memberName" + subscription.getMember().getClass());
          String memberName = subscription.getMember().getName();
          System.out.println("After accessing memberName" + memberName);
          return SubscriptionResponseDto.from(subscription);
        })
        .toList();
  }
}
