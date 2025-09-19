package practice.day3;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public void insertMember() {
    memberRepository.save(new Member(1l, "길동"));
  }

  public List<Member> getAllMembers() {
    return memberRepository.findAll();
  }

  public Member getMemberById(Long id) {
    return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 맴버가 없습니다."));
  }

  public void deleteMemberById(Long id) {
    memberRepository.deleteById(id);
  }
}
