import java.util.EmptyStackException;

class Stack<E> {
  LinkedList<E> link;
  
  public Stack() {
    link = new LinkedList<>();
  }
  
  // -> void
  // adds the Item to the top(size()) of the list.
  public void push(E item) {
    int index = link.size();
    link.add(item, index);
  }
  
  // -> E
  // removes the Item from the top(size()) of the list.
  public E pop() {
    int index = link.size() - 1;
    return link.remove(index);
  }
  
  // -> E
  // returns the item at the top(size()) of the list.
  public E peek() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }
    int index = link.size() - 1;
    return link.getData(index);
  }
  
  // -> boolean
  // checks whether the list is empty or not.
  public boolean isEmpty() {
    return (link.size() == 0);
  }
  
  // -> int
  // returns the size of the list.
  public int size() {
    return link.size();
  }
  
  public void display() {
    link.display();
  }
}