import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JUnitTest {
  @DisplayName("1 + 2는 3이다")  // 테스트 이름
  @Test
  public void test() {
    int a = 1;
    int b = 2;
    int sum = 3;

    Assertions.assertEquals(sum, a + b);  // 값이 같은지 검증
  }

  @DisplayName("1 + 3은 4이다")
  @Test
  public void failedTest() {
    int a = 1;
    int b = 3;
    int sum = 3;

    Assertions.assertEquals(sum, a + b);  // 실패하는 테스트 케이스
  }
}

