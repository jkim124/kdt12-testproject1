package day12.Team.dto;

import day12.Team.domain.Team;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TeamResponseDto {
  private final Long id;
  private final String name;
  private final List<MemberResponseDto> members;

  @Builder
  public TeamResponseDto(Long id, String name, List<MemberResponseDto> members) {
    this.id = id;
    this.name = name;
    this.members = members;
  }

  // 엔티티 → DTO 변환용
  public static TeamResponseDto from(Team team) {
    return TeamResponseDto.builder()
        .id(team.getId())
        .name(team.getName())
        .members(team.getMembers()
            .stream()
            // ClassName::methodName
            .map(MemberResponseDto::from)
            .toList())
        .build();
  }

}