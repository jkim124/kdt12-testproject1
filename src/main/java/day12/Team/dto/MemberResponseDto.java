package day12.Team.dto;

import day12.Team.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {
  private final Long id;
  private final String name;

  @Builder
  public MemberResponseDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  // 엔티티 → DTO 변환용
  public static MemberResponseDto from(Member member) {
    return MemberResponseDto.builder()
        .id(member.getId())
        .name(member.getName())
        .build();
  }

}