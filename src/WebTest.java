import org.testng.annotations.Test;

public class WebTest {

  // **** BREAKPOINTS IMPOSSIBLE HERE ****

  private int m_numberOfTimes;
  public WebTest(int numberOfTimes) {
    m_numberOfTimes = numberOfTimes;
  }

  @Test
  public void testServer() {
   for (int i = 0; i < m_numberOfTimes; i++) {
	   System.out.println("Inside testServer "+ i);
    }
  }
}