package practice.example.team.service;


import practice.example.team.domain.Member;
import practice.example.team.domain.Team;
import practice.example.team.dto.MemberRequest;
import practice.example.team.dto.MemberResponse;
import practice.example.team.dto.TeamRequest;
import practice.example.team.dto.TeamResponse;
import practice.example.team.repository.TeamRepository;
import practice.example.team.repository.MemberRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TeamMemberService {
  private final TeamRepository teamRepository;
  private final MemberRepository memberRepository;

  public TeamMemberService(TeamRepository teamRepository, MemberRepository memberRepository) {
    this.teamRepository = teamRepository;
    this.memberRepository = memberRepository;
  }

  public List<TeamResponse> getAllTeams() {
    return teamRepository.findAll().stream()
        .map(TeamResponse::new)
        .collect(Collectors.toList());
  }
  public TeamResponse getTeam(Long id){
    Team team = teamRepository.findById(id).orElseThrow();
    return new TeamResponse(team);
  }
  public TeamResponse createTeam(TeamRequest teamRequest) {
    Team team = Team.builder()
        .name(teamRequest.getName())
        .build();
    teamRepository.save(team);
    return new TeamResponse(team);
  }

  public TeamResponse updateTeam(Long id, TeamRequest teamRequest) {
    Team team = teamRepository.findById(id).orElseThrow();
    team.update(teamRequest.getName());
    return new TeamResponse(team);
  }


  public List<MemberResponse> getAllMemberTeams() {
    return memberRepository.findAll().stream()
        .map(MemberResponse::new)
        .collect(Collectors.toList());
  }


  public MemberResponse createMember(Long teamId,MemberRequest memberRequest) {
    Team team = teamRepository.findById(teamId).orElseThrow();
    Member member = Member.builder()
        .username(memberRequest.getUsername())
        .team(team)
        .build();
    Member saved = memberRepository.save(member);
    return new MemberResponse(saved);
  }
}
