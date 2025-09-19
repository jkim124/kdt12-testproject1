package day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class PersonTest {
  @Test
  public void test() {
    Person person = new Person();
    person.setId(123L);
    person.setName("Anything");
    person.setAge(20);
    person.setHobbies(List.of("줄넘기", "달리기"));

    person.getId();
    person.getName();
    person.getAge();
    person.getHobbies();
  }
}