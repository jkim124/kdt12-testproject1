package day12.Team.service;

import day12.Team.domain.Member;
import day12.Team.dto.MemberResponseDto;
import day12.Team.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final EntityManager em;
  private final MemberRepository memberRepository;
  public Long join(Member member) {  // 회원가입
       long startTimeMs = System.currentTimeMillis();
        try {
    validateDuplicateMember(member); //중복 회원 검증
    memberRepository.save(member);
    return member.getId();
       } finally { // try 블록의 코드 실행이 성공적으로 끝나거나, 도중에 예외가 발생하더라도 finally 블록은 무조건 실행
           long finishTimeMs = System.currentTimeMillis();
           long timeMs = finishTimeMs - startTimeMs;
            System.out.println("join " + timeMs + "ms");
        }
  }

  public List<MemberResponseDto> findMembers() {   // 전체 회원 조회
        long startTimeMs = System.currentTimeMillis();
        try {
    return memberRepository.findAll().stream()
        .map(MemberResponseDto::from)
        .toList();
        } finally {
            long finishTimeMs = System.currentTimeMillis();
            long timeMs = finishTimeMs - startTimeMs;
            System.out.println("findMembers " + timeMs + "ms");
        }
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원입니다: " + member.getName());
        });
  }

  public List<MemberResponseDto> getAllMembersWithTeams() {
    return memberRepository.findAllByTeamIsNotNull()
        .stream()
        .map(member -> {
          System.out.println("Before accessing teamName: " + member.getTeam().getClass());
          String teamName = member.getTeam().getName(); // LAZY 로딩 발생
          System.out.println("After accessing teamName: " + teamName);
          return MemberResponseDto.from(member);
        })
        .toList();
  }

  @Transactional
  public void persistAndFind() {
    System.out.println("=== 시작 코드 ===");
    // 1. 새로운 Member 생성
    Member member = Member.builder()
        .id(1L)
        .name("이강인")
        .build();
    System.out.println("=== 생성 호출 완료 ===");
    // 2️. 영속성 컨텍스트에 저장 (아직 DB INSERT 안 함)
    em.persist(member);

    System.out.println("=== persist 호출 완료 ===");

    // 3️. 같은 트랜잭션 안에서는 영속성 컨텍스트 먼저 바로 조회
    Member findMember = em.find(Member.class, member.getId());

    System.out.println("조회 결과: " + findMember.getName());
    System.out.println("같은 객체? " + (member == findMember)); // true

    // 트랜잭션 commit 시점에 flush → DB에 INSERT 실행
  }
}