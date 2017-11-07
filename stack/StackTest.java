import junit.framework.TestCase;

public class StackTest extends TestCase {
  public void testPush() {
    Stack stacked = new Stack();
    stacked.push("kobe");
    stacked.push("pacman");
    stacked.push("pacito");
  }
}
