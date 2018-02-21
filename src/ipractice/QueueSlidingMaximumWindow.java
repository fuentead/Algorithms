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
 * --
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
 * 
 */
public class QueueSlidingMaximumWindow {
     
   public static void maximumSlidingWindow(int[] data, int k) {
      if(data.length == 0)
         return;
      
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(0);
      for(int i=1; i<data.length; i++) {
         int index = q.peek();
         while(!q.isEmpty() && (data[index] < data[i] || q.size() >= k))
            q.poll();
         q.add(i);
         index = q.peek();
         if(i >= k-1)
            System.out.print(data[index] + " ");
      }
   }

   public static void main(String[] args) {
      int[] data = {1, 3, -2, -3, 5, 4, 6, 7};
      maximumSlidingWindow(data, 3);
   }
}
