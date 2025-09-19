package day12.sil.dto;

import day12.sil.domain.Member;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {
  private final Long id;
  private final String name;
  private final List<SubscriptionResponseDto> subscriptions;

  @Builder
  public MemberResponseDto (Long id, String name, List<SubscriptionResponseDto> subscriptions) {
    this.id = id;
    this.name = name;
    this.subscriptions = subscriptions;
  }

  // 엔티티 → DTO 변환용
  public static MemberResponseDto  from(Member member) {
    return MemberResponseDto.builder()
        .id(member.getId())
        .name(member.getName())
        .subscriptions(member.getSubscriptions()
            .stream()
            // ClassName::methodName
            .map(SubscriptionResponseDto::from)
            .toList())
        .build();
  }


}
