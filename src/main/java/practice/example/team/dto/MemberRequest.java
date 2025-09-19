package practice.example.team.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequest {
  private String username;
  private Long teamId;
}
