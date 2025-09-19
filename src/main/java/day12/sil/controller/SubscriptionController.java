package day12.sil.controller;

import day12.sil.dto.SubscriptionResponseDto;
import day12.sil.service.SubscriptionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SubscriptionController {

  private final SubscriptionService subscriptionService;


  @GetMapping("/subscription")
  public List<SubscriptionResponseDto> getSubscription() {
    List<SubscriptionResponseDto> subscriptions = subscriptionService.getAllSubscriptionsWithMembers();
    return subscriptions;
  }
}
