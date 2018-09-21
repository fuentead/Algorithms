package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Find pairs that sum to k.
 * ---
 */

public class ArraysPairSumK {

   public static boolean pairSumK(int[] data, int k) {     
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      int val;
      for(int i=0; i<data.length; i++) {
         if(map.containsKey(data[i]))
            val = map.get(data[i]);
         else 
            val = 0;
         map.put(data[i], val+1);
      }
      
      for(int i=0; i<data.length; i++) {
         int diff = Math.abs(data[i] - k);
         if(map.containsKey(diff)) {
            if((diff == data[i]) && (map.get(diff) < 2)) 
               return false;            
            else     
               return true;            
         }
      }
      return false;
   }
   
   public static void main(String[] args) {
      int[] data = {0, 1, 5, 5, 2, 4, 3, 1, 7};  
      boolean res1 = pairSumK(data, 7);
      System.out.println(res1);
      
      int[] data2 = {5,4,2,4};
      boolean res2 = pairSumK(data2, 8);
      System.out.println(res2);
      
      int[] data3 = {5,1,2,4};
      boolean res3 = pairSumK(data3, 8);
      System.out.println(res3);
   }
}
