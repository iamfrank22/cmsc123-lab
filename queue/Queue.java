import java.lang.IllegalArgumentException;

class Queue {
  String[] array;
  int capacity;
  int size;
  int front;
  int rear;
  
  Queue(int capacity) {
    this.capacity = capacity;
    array = new String[this.capacity];
    size = 0;
    front = 0;
    rear = 0;
  }
  
  public void enqueue(String item) {
    if(this.size == this.capacity) {
      expandArray();
    }
      array[rear] = item;
      rear = (rear + 1) % capacity;
      size++;
  }
  
  public String dequeue() {
    String item;
    if(isEmpty()) {
      throw new IllegalArgumentException("Queue underflow!");
    }
    item = array[front];
    array[front] = null;
    front = (front + 1) % this.capacity;
    
    return item;
  }
  
  public String peek() {
    if(isEmpty()) {
      throw new IllegalArgumentException("Queue underflow!");
    }
    return array[front];
  }
  
  public boolean isEmpty() {
    return (size == 0);
  }
  
  public void expandArray() {
    this.capacity*=2;
    String[] newArray = new String[this.capacity];
    for(int a = 0; a < this.size; a++){
      newArray[a] = array[front];
      front = (front + 1) % this.capacity;
    }
    front = 0;
    rear = this.size;
    array = newArray;
  }
  
  public int size() {
    return this.capacity;
  }
  
  public void display() {
    int i = 0;
    while(i != rear) {
      System.out.println(array[i]);
      i = (i + 1) % this.capacity;
    }
  }
}