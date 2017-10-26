import junit.framework.TestCase;
import java.util.*;

public class LinkedListTest extends TestCase {
  public void testAdd() {
    LinkedList<String> link = new LinkedList<String>();
    assertEquals(true, link.add("kobe", 0));
    assertEquals(true, link.add("pacman", 1));
    assertEquals(true, link.add("pacito", 2));
  }
  
  public void testRemove() {
    LinkedList<String> link = new LinkedList<String>();
    
    link.add("kobe", 0);
    link.add("pacman", 1);
    link.add("pacito", 2);
    assertEquals(true, link.remove(2));
  }
  
  public void testHasNext() {
    LinkedList<String> link = new LinkedList<String>();
    
    link.add("kobe", 0);
    link.add("pacman", 1);
    link.add("pacito", 2);
    
    Iterator iter = link.iterator();
    
    assertEquals(true, iter.hasNext());
  }
  
  public void testNext() {
    LinkedList<String> link = new LinkedList<String>();
    
//    link.add("kobe", 0);
//    link.add("pacman", 1);
//    link.add("pacito", 2);
//    link.add("frank", 0);
    
    Iterator iter = link.iterator();
    
    while(iter.hasNext())
      System.out.println(iter.next() + " ");
  }
}
