import java.util.*;

class HashTable {
  class HashNode {
    String key;
    int value;
    HashNode next;
  
    HashNode(String key, int value) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }
  
  int MAX_SIZE; // maximum capacity of the hash table
  int size; //number of elements
  HashNode[] hashTable; // array of linked lists
  
  // constructor
  HashTable() {
    MAX_SIZE = 100;
    hashTable = new HashNode[MAX_SIZE];
    
    //make the initial chains empty
    for (int i = 0; i < MAX_SIZE; i++)
      hashTable[i] = null;
  }
  
  // function which inserts a key value pair to a hash
  public void put(String key, int value) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      hashTable[hash] = new HashNode(key, value);
    }
    else {
      HashNode newNode = hashTable[hash];
      while(newNode.next != null && newNode.key != key) {
        newNode = newNode.next;
      }
      if(newNode.key == key) {
        newNode.value = value;
      }
      else {
        newNode.next = new HashNode(key, value);
      }
    }
    size++;
  }
  
  // function which returns the value of a given key
  public int get(String key) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      return -1;
    }
    
    HashNode newNode = hashTable[hash];
    while(newNode.next != null && newNode.key != key) {
      newNode = newNode.next;
    }
    if(newNode.key == null) {
      return -1;
    }
    return newNode.value;
  }
  
  // function which removes the value associated with the key and returns it.
  public int remove(String key) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      return -1;
    }
    
    HashNode previous = null;
    HashNode newNode = hashTable[hash];
      
    while(newNode.next != null && newNode.key != key) {
      previous = newNode;
      newNode.next = newNode;
    }
    if(newNode.key == null) {
      return -1;
    }
    
    if(previous == null)
      hashTable[hash] = newNode.next;
    else
      previous.next = newNode.next;
    
    size--;
    return newNode.value;
  }
  
  // function which returns true if the key exists in the hash table. False, otherwise.
  public boolean contains(String key) {
    int hash = (getHash(key) % MAX_SIZE);
    
    if(hashTable[hash] == null) {
      return false;
    }
    HashNode newNode = hashTable[hash];
    while(newNode.next != null && newNode.key != key) {
      newNode.next = newNode;
    }
    if(newNode.key == null) {
      return false;
    }
    return true;
  }
  
  // function which prints a list of values in the hash table
  public List values() {
    List valueList = new ArrayList();
    for (int i = 0; i < MAX_SIZE; i++) {
      HashNode newNode = hashTable[i];
      while (newNode != null) {
        valueList.add(newNode.value);
        newNode = newNode.next;
      } 
    }
    return valueList;
  }
  
  // function which prints a list of keys in the hash table
  public List keys() {
    List keyList = new ArrayList();
    for (int i = 0; i < MAX_SIZE; i++) {
      HashNode newNode = hashTable[i];
      while (newNode != null) {
        keyList.add(newNode.key);
        newNode = newNode.next;
      } 
    }
    return keyList;
  }
  
  // function which gives the hash value of the String
  public int getHash(String key) {
    int hashCode = key.hashCode();
    int hashValue = hashCode % MAX_SIZE;
    return hashValue;
  }
  
  // function which prints the hash table
  public void display() {
    for (int i = 0; i < MAX_SIZE; i++) {
      System.out.println("\nHash Index "+ (i + 1) +" : ");
      HashNode newNode = hashTable[i];
      while (newNode != null) {
        System.out.print(newNode.value +" ");
        newNode = newNode.next;
      } 
    }
  }
}