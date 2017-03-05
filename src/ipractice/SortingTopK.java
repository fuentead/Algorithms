package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Find K largest elements from a given stream of numbers.
 * By definition, we don't know the size of the input 
 * stream. Hence, produce k largest elements seen so far,
 * at any given time.
 * 
 *  - Input may or may not be sorted and could have duplicates.
 *  - Represent input stream as an array. Do not rely on its size.
 *  - Feel free to use built-in functions if you need a specific 
 *    data-structure.
 *  - If your output is correct, but a test-case is failing because 
 *    order of output elements is different, move on.
 */
public class SortingTopK {

   public static PriorityQueue<Integer> findTopK(int[] data, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      if(data.length == 0)
         return null;

      int i=0;
      while(i < data.length) {
         if(pq.size() == k) {
            if(data[i] > pq.peek()) {
               pq.poll();
               pq.add(data[i]);
            }               
         }
         else
            pq.add(data[i]);
         i++;
      }
      return pq;
   }
   
   public static void main(String[] args) {
      int[] data = { 6, 22, 69, 3, 5, 4, 89, 34, 8, 44, 55};
      
      PriorityQueue<Integer> pq = findTopK(data, 3);
      while(!pq.isEmpty()) {
         int n = pq.poll();
         System.out.print(n + " ");
      }
   }

}
