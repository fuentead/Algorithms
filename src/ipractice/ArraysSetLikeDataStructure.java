package ipractice;

import java.util.*;

public class ArraysSetLikeDataStructure {
   
   private Map<Integer, Integer> map;
   private List<Integer> arrayL;
    
   public ArraysSetLikeDataStructure() {
      this.map = new HashMap<Integer, Integer>();
      this.arrayL = new ArrayList<Integer>();
   }

   public void insert(int num) {
      if(map.containsKey(num))
         return;
      
      arrayL.add(num);
      int index = arrayL.size()-1;
      map.put(num, index);
   }
   
   public boolean remove(int num) {
      if(map.containsKey(num)) {
         int index = map.get(num);
         map.remove(num);
         
         // swap values
         int lastindex = arrayL.size()-1;
         int tmpval = arrayL.get(lastindex);
         arrayL.set(lastindex, num);
         arrayL.set(index, tmpval);
         arrayL.remove(lastindex);
         
         map.put(tmpval, index);
         return true;
      }
      return false;
   }

   public int getrandom() {
      int size = map.size();
      Random rand = new Random();
      int index = rand.nextInt(size);
      
      int num = arrayL.get(index);
      return num;
   }
   
   public void print() {
      System.out.println("array");
      for(int val : arrayL) {
         System.out.print(val + " ");
      }
      System.out.println("\nmap");
      for(int key : map.keySet())
         System.out.println(key + " " + map.get(key));
   }
   
   public static void main(String[] args) {
      ArraysSetLikeDataStructure set = new ArraysSetLikeDataStructure();
      set.insert(1);
      set.insert(2);
      set.insert(3);
      set.insert(4);
      set.insert(5);
      set.print();

      int num = set.getrandom();
      System.out.println("random: " + num);
      
      boolean res = set.remove(2);
      System.out.println(res);
      set.print();

      boolean res2 = set.remove(1);
      System.out.println(res2);
      set.print();
      
      set.insert(6);
      set.print();
   }
}
