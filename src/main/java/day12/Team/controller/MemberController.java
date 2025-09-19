package day12.Team.controller;

import day12.Team.domain.Member;
import day12.Team.dto.MemberResponseDto;
import day12.Team.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  /**
   * 회원 가입
   */
  @PostMapping("/members")
  public String createMember(@RequestBody Member member) {
    Long memberId = memberService.join(member);
    return "회원가입 완료! 생성된 회원 ID: " + memberId;
  }

  /**
   * 전체 회원 조회
   */
  @GetMapping("/members")
  public List<MemberResponseDto> getMembers() {
    return memberService.findMembers();
  }

  @GetMapping("/users")
  public List<MemberResponseDto> getUser() {
    List<MemberResponseDto> members = memberService.getAllMembersWithTeams();
    return members;
  }

  @GetMapping("/test")
  public void persistAndFind() {
    memberService.persistAndFind();
  }

}