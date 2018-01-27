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

   public static void pairSumK(int[] data, int k) {     
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      //insert values in hashmap
      int val;
      for(int i=0; i<data.length; i++) {
         if(map.containsKey(i))
            val = map.get(i);
         else 
            val = 0;
         map.put(i, val+1);
      }
      
      // Print anything found that is less than this number
      for(int i=0; i<data.length; i++) {
         int diff = Math.abs(data[i] - k);
         if(diff <= data[i]) { // to avoid printing repeated elements
            if(map.containsKey(diff)) {
               val = map.get(diff);
               for(int j=0; j<val; j++)
                  System.out.println(data[i] + " + " + diff);
            }  
         }
      }    
   }
   
   public static void main(String[] args) {
      int[] data = {0, 1, 5, 5, 2, 4, 3, 1, 7};  
      pairSumK(data, 7);
   }
}
