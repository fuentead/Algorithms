package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Design an LRU cache
 * 
 * add and get methods function in O(1) with a Linked List
 */
public class LinkedListLRUCacheDesign {
   
   private Node head;
   private Node tail;
   private int size;
   private int maxsize;
   private Map<Integer, Node> hm;
   
   public LinkedListLRUCacheDesign(int maxsize) {
      this.hm = new HashMap<Integer, Node>();
      this.head = null;
      this.tail = null;
      this.size = 0;
      this.maxsize = maxsize;
   }

   static class Node {
      int value;
      Node next;
      Node prev;
      
      Node(int value) {
         this.value = value;
         this.next = null;
         this.prev = null;
      }
   }
   
   // Linked List Methods
   public Node addLL(int value) {
      if(head == null) {
         head = new Node(value);  
         tail = head;
      }
      else {
         Node n = new Node(value);
         n.next = head;
         head.prev = n;
         head = n;
      }
      return head;
   }
   
   public void deleteLLTail() {
      Node tmp = tail.prev;
      tmp.next = null;
      tail = tmp;
   }
   
   public Node moveRecentlyUsed(Node n) {      
      if(n == tail) {
         Node tmp = n.prev;
         tmp.next = null;
      }
      else {
         Node tmp = n.prev;
         tmp.next = n.next;
         n.next.prev = tmp;
      }          
      n.next = head;
      head.prev = n;
      head = n;
      
      return head;
   }
   
   // Cache Methods
   public Node add(int value) {
      
      // Evict since cache is maxsize
      if(size == maxsize) {
         // Delete from map cache tail element         
         hm.remove(tail.value);
         deleteLLTail();
         size--;
      }
      
      // Add to LRU Cache and map
      if(hm.containsKey(value)) {
         Node n = hm.get(value);
         moveRecentlyUsed(n);
      }
      else {         
         Node n = addLL(value);
         hm.put(value, n); 
      }
      size++;
      return head;
   }
   
   public Node get(int value) {
      if(hm.containsKey(value)) {
         Node n = hm.get(value);
         moveRecentlyUsed(n);
         return n;
      }
      else {
         System.out.println("Does not exist in cache : " + value);
         return null;
      }
   }
   
   public void printLRU() {
      Node tmp = head;
      System.out.println("Linked List LRU");
      while(tmp != null) {
         System.out.print(tmp.value + " ");
         tmp = tmp.next;
      }  
      
      System.out.println("\nHashMap for LRU");
      Iterator<Map.Entry<Integer, Node>> i = hm.entrySet().iterator();
      while(i.hasNext()) {
         int nvalue = i.next().getKey();
         System.out.println(nvalue + " : " + hm.get(nvalue).value);
      }
   }
   
   public static void main(String[] args) {
      LinkedListLRUCacheDesign lru = new  LinkedListLRUCacheDesign(4);
      lru.add(1);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      lru.add(2);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      lru.add(3);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      lru.add(4);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      lru.add(5);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      lru.get(1);
      System.out.println("\nhead is: " + lru.head.value);
      
      lru.get(3);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      
      lru.get(4);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
      
      lru.add(1);
      System.out.println("\nhead is: " + lru.head.value);
      lru.printLRU();
   }
}
