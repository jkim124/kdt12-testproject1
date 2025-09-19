package practice.example.team.controller;

import practice.example.team.dto.MemberRequest;
import practice.example.team.dto.MemberResponse;
import practice.example.team.dto.TeamRequest;
import practice.example.team.dto.TeamResponse;
import practice.example.team.service.TeamMemberService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

  @RestController
  @RequestMapping("/api")
  public class TeamMemberController {

    private final TeamMemberService service;

    public TeamMemberController(TeamMemberService service) {
      this.service = service;
    }

    @GetMapping("/teams")
    public List<TeamResponse> getAllTeams() {
      return service.getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public TeamResponse getTeam(@PathVariable Long id) {
      return service.getTeam(id);
    }

    @PostMapping("/teams")
    public TeamResponse createTeam(@RequestBody TeamRequest request) {
      return service.createTeam(request);
    }

    @PutMapping("/teams/{id}")
    public TeamResponse updateTeam(@PathVariable Long id, @RequestBody TeamRequest request) {
      return service.updateTeam(id, request);
    }

    @GetMapping("/members")
    public List<MemberResponse> getAllMembers() {
      return service.getAllMemberTeams();
    }

    @PostMapping("/teams/{id}/members")
    public ResponseEntity<MemberResponse> createMember(@PathVariable("id") Long teamId, @RequestBody MemberRequest request) {
      MemberResponse response = service.createMember(teamId,request);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
  }

