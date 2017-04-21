package ipractice;

/**
 * @author Adriana Fuentes
 *
 * There are n houses build in a line, each of which
 * contains some value in it. A thief is going to 
 * steal the maximal value in these houses, but he 
 * cannot steal in two adjacent houses because the 
 * owner of a stolen house will tell his two neighbors
 * on the left and right side. What is the maximal stolen
 * value?
 * 
 * For example, if there are four houses with values
 * {6,1,2,7}, the maximal stolen value is 13 when the first
 * and fourth houses are stolen.
 */
public class DPRobbery {
   
   /*
    * Recursive exhaustive search
    * 
    * Time complexity: O(n) 
    * Space Complexity: O(n) due to stack usage during recursion.
    */
   public static int robberyExhaustiveSearchRecursive(int[] data) {
      if(data.length == 0)
         return 0;
      
      int max = 0;
      for(int i=0; i < data.length; i++) 
         max = Math.max(max, robberyExhaustiveSearchRecursiveHelper(data, i));      
      return max;
   }

   public static int robberyExhaustiveSearchRecursiveHelper(int[] data, int i) {
      if(i > data.length-1)
         return 0;
      
      // Include number at i
      int sumIncl = data[i] + robberyExhaustiveSearchRecursiveHelper(data, i+2);
      
      // Do Not Include number at i
      int sumNotIncl = robberyExhaustiveSearchRecursiveHelper(data, i+1);
      
      return Math.max(sumIncl, sumNotIncl);
   }
   
   /*
    * Iterative exhaustive search
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    */
   public static int robberyIterativeSearch(int[] data) {
      if(data.length == 0)
         return 0;
      
      if(data.length == 1)
         return data[0];
      
      int oddmax = 0; int evenmax = 0;
      for(int i=0; i<data.length; i++) {
         // If even: to include it, choose previous even 
         // number. To exclude it, choose previous odd.
         if(i % 2 == 0) 
            evenmax = Math.max(oddmax, evenmax + data[i]);
         
         // If odd: to include it, choose previous odd 
         // number. To exclude it, choose previous even.
         else 
            oddmax = Math.max(evenmax, oddmax + data[i]);         
      }
      return Math.max(evenmax, oddmax);
   }
   
   /*
    * Dynamic Programming Solution
    * Find relation: dp[i] = Math.max(dp[i-1], dp[i-2] + data[i])
    * 
    * Time Complexity O(n)
    * Space Complexity O(n)
    */
   public static int robberyDP(int[] data) {
      if(data.length == 0)
         return 0;
      
      if(data.length == 1)
         return data[0];
      
      int[] dp = new int[data.length];
      int i=0;
      dp[i] = data[i];
      i++;
      dp[i] = Math.max(data[i-1], data[i]);
      
      for(i=2; i<data.length; i++)
         dp[i] = Math.max(dp[i-1], dp[i-2] + data[i]);
      
      return dp[data.length-1];
   }
   
   public static void main(String[] args) {
      int[] data = {6,1,2,7};
      int res1 = robberyExhaustiveSearchRecursive(data);
      System.out.println("Exhaustive Recursive: " + res1);
      
      int res2 = robberyIterativeSearch(data);
      System.out.println("Exhaustive Iterative Search: " + res2);
      
      int res3 = robberyDP(data);
      System.out.println("Dynamic Programming: " + res3);
   }
}
