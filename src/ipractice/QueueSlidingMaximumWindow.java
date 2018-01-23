package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * A long array A[] is given. There is a sliding window 
 * of size w which is moving from the left of the array to
 * the right of the array. Only the w numbers can be 
 * seen in the window. Each time the sliding window moves 
 * rightwards by one position. 
 * ---
 * Following is an example:
 * The array is [1 3 -1 -3 5 4 6 7], and w is 3.
 * 
 * Window position            Max
 * ---------------            ---
 * [1 3 -1] -3 5 4 6 7         3
 * 1 [3 -1 -3] 5 4 6 7         3
 * 1 3 [-1 -3 5] 4 6 7         5
 * 1 3 -1 [-3 5 4] 6 7         5
 * 1 3 -1 -3 [5 4 6] 7         6
 * 1 3 -1 -3 5 [4 6 7]         7
 * 
 * Input: A long array A[], and a window width w
 * Output: An array B[], B[i] is the maximum value
 * of from A[i] to A[i+w-1]
 * Requirement: Find a good optimal way to get B[i]
 */
public class QueueSlidingMaximumWindow {
   
   public static void checkWindowQueueContent(int[] data, int i, Queue<Integer> q) {    
      if(q.isEmpty()) 
         return;    
      int index = q.peek();
      while(!q.isEmpty() && data[index] < data[i]) {
         q.remove();
         if(!q.isEmpty()) index = q.peek();
      } 
   }
   
   public static void printMaxWindowElement(int[] data, Queue<Integer> q) {
      if(q.isEmpty())
         return;     
      int index = q.peek();
      System.out.println(data[index]);     
   }
   
   public static boolean slidingMaximumWindow(int[] data, int wsize){
      if(wsize > data.length)
         return false;
      
      Queue<Integer> q = new LinkedList<Integer>();
      int istart, i;
      istart=0;
      
      // Add initial window
      q.add(0);     
      for(i=1; i<wsize; i++) {
        checkWindowQueueContent(data, i, q);
        q.add(i);
      }
      printMaxWindowElement(data, q);
      
      // Check consecutive windows
      for(i=wsize; i<data.length; i++) {
         istart++;         
         if(q.peek() < istart)
            q.remove();
         checkWindowQueueContent(data, i, q);
         q.add(i);
         printMaxWindowElement(data, q);
      }     
      return true;
   }

   public static void main(String[] args) {
      int[] data = {1, 3, -2, -3, 5, 4, 6, 7};
      slidingMaximumWindow(data, 3);
   }
}
