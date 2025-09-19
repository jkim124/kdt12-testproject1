package practice.example.team.dto;

import practice.example.team.domain.Team;
import lombok.Getter;

@Getter
public class TeamResponse {
  private Long id;
  private String name;

  public TeamResponse(Team team) {
    this.id = team.getId();
    this.name = team.getName();
  }
}
