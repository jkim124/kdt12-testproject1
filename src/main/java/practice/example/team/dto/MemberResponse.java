package practice.example.team.dto;

import practice.example.team.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {
  private long id;
  private String userName;
  private TeamResponse team;


  public MemberResponse(Member member) {
    this.id = member.getId();
    this.userName = member.getUsername();
    if (member.getTeam() != null) {
      this.team = new TeamResponse(member.getTeam());
    }
  }
}
