package day12.Team.repository;

import day12.Team.domain.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Object> findByName(String name);
  //@Query("SELECT m FROM Member m JOIN FETCH m.team")
  List<Member> findAllByTeamIsNotNull();
}