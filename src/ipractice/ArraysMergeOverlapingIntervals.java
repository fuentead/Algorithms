package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a set of time intervals in any order, merge
 * all overlapping intervals into one and output the 
 * result which should have only mutually exclusive 
 * intervals.
 * 
 * Examples:
 * {{1,3},{2,4},{5,7},{6,8}}
 * Intervals are {1,3} and {2,4} overlap with each other, 
 * so they shold be merged and become {1,4}. Similarly, 
 * {5,7} and {6,8} should be merged and become {5,8}
 */
public class ArraysMergeOverlapingIntervals {
   
   static class Tuple {
      int x;
      int y;
      Tuple(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }

   /*    
    * Quicksort: in-place algorithm, no additional space needed.
    * Efficiency of quicksort depends on the pivot chosen.
    */
   private static void quicksort(Tuple[] data, int istart, int iend) {
      if(istart >= iend)
         return;
      
      // Choose pivot
      int ipivot = partition(data, istart, iend);
      quicksort(data, istart, ipivot-1);
      quicksort(data, ipivot+1, iend);
   }
   
   private static int partition(Tuple[] data, int istart, int iend) {
      int ipivot = istart; // pivot index
      int i = istart + 1; // traversing array
      int p = istart; // index for elements greater or smaller than pivot
      
      while(i <= iend) {
         if(data[i].x < data[ipivot].x) {
            p++;
            swap(data, i, p);
         }
         i++;
      }
      swap(data, ipivot, p); // Swap pivot with value of index p
      return p; // return pivot index
   }
   
   private static void swap(Tuple[] data, int a, int b) {
      Tuple tmp = data[a];
      data[a] = data[b];
      data[b] = tmp;      
   }

   /*
    * Solve overlapping interval by:
    * 1) Sorting with quicksort first elements.
    * 2) Using stack to find overlapping intervals
    */
   public static Stack<Tuple> mergeOverlappingInterval(Tuple[] data) {      
      Stack<Tuple> stack = new Stack<Tuple>();
      
      // Sort by first elements with quicksort
      quicksort(data, 0, data.length-1);
      
      stack.add(data[0]);
      for(int i=1; i<data.length; i++) {
         if((stack.peek().x < data[i].x) && (stack.peek().y > data[i].x) && (stack.peek().y < data[i].y)) {
            Tuple tmp = stack.pop();
            tmp.y = data[i].y;
            stack.push(tmp);
         }
         else
            stack.push(data[i]);
      }
      return stack;
   }
   
   public static void main(String[] args) {
      Tuple[] data = {new Tuple(2,4), new Tuple(1,3), new Tuple(5,7), new Tuple(6,8)};
      Stack<Tuple> result = mergeOverlappingInterval(data);
      System.out.println(" Results ");
      while(!result.isEmpty()) {
         System.out.println("(" + result.peek().x + "," + result.peek().y + ")");
         result.pop();
      }
   }
}
