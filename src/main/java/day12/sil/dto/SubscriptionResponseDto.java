package day12.sil.dto;

import day12.sil.domain.Subscription;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SubscriptionResponseDto {
  private final Long id;
  private final String name;

  @Builder
  public SubscriptionResponseDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  // 엔티티 → DTO 변환용
  public static SubscriptionResponseDto from(Subscription subscription) {
    return SubscriptionResponseDto.builder()
        .id(subscription.getId())
        .name(subscription.getName())
        .build();
  }
}
