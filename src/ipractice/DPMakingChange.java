package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * You are given n types of coin denominators of values
 * v(1) < v(2) < ... < v(n) (all integers). Give an algorithm which
 * makes change for an amount of money C with as few coins as possible.
 *  
 *   * Assume there are multiple coins of every denomination.
 *   * Assume v(1) = 1, (i.e. there is always a combination that leads to C).
 *   * There may be multiple ways of reaching C. We want a DP based solution that 
 *     leads to the method using least number of coins.
 *   * Input: C and Denominations Array
 *   * Output: Combination using minimum number of coins (repeat coins ok) that leads to C. Print any one
 *   
 * Extra: Print all combinations. Hint: You'll need to do recursion on the DP table.
 * 
 * e.g.
 * Input: Denominations: 1,2,3
 * C:4
 * Output on two lines:
 * 1,3
 * 2,2
 * 
 */
public class DPMakingChange {
   
   /*
    * Counts all possible solutions for making change recursively.
    */
   public int recursiveMakingChangeCount(int[] coins, int numCoins, int totalSum) {     
      if(totalSum == 0)
         return 1;        
      if((numCoins == 0) && (totalSum > 0))
         return 0;      
      if(totalSum < 0)
         return 0;                    
      return recursiveMakingChangeCount(coins, numCoins-1, totalSum) + recursiveMakingChangeCount(coins, numCoins, totalSum - coins[numCoins-1]);     
   }
   

   /*
    * Recursive - Count minimum number of coins needed to make this change.
    */
   public int recursiveMakingChangeMinimunCoins(int[] coins, int totalSum) {
      if(totalSum == 0)
         return 0;
      else {
         // for all coin values 
         int mincoins = Integer.MAX_VALUE;
         for(int coin : coins) {
            if(coin <= totalSum)
               mincoins = Math.min(mincoins,recursiveMakingChangeMinimunCoins(coins, totalSum-coin));            
         }
         return mincoins + 1;
      }     
   }
   
   /*
    * Recursive with cache - Count minimum number of coins needed to make this change.
    */
   public int recursiveCacheMakingChangeMinimumCoins(int[] coins, int totalSum, int[] cache) {
      if(totalSum == 0)
         return cache[0];
      else {
         int mincoins = Integer.MAX_VALUE;
         // for all coin values
         for(int i=0; i<coins.length; i++) {
            if(coins[i] <= totalSum) {
               if(cache[totalSum - coins[i]] == Integer.MAX_VALUE) 
                  cache[totalSum - coins[i]] = recursiveCacheMakingChangeMinimumCoins(coins, totalSum - coins[i], cache);
               mincoins = Math.min(mincoins, cache[totalSum - coins[i]]);
            }
         }
         return mincoins + 1;
      }
   }
   
   /*
    * Dynamic Programming - Count minimum number of coins needed to make this change.
    */
   public int dpMakingChangeMinimumCoins(int[] coins, int totalSum, int[] cache) {
      int mincoins = Integer.MAX_VALUE;
      for(int v=0; v<=totalSum; v++) {
         if(cache[v] == Integer.MAX_VALUE) {
            int numcoins = Integer.MAX_VALUE;
            for(int coin : coins) {
               if(coin <= v) {
                  int change = v - coin;
                  numcoins = 1 + cache[change];
                  mincoins = Math.min(mincoins, numcoins);
               }
            }
            cache[v] = mincoins;
         }
      }
      return cache[totalSum];
   }

   public static void main(String[] args) {
      
      // Recursive example - all possible solutions
      DPMakingChange mc = new DPMakingChange();
      int[] data = {1,2,3};
      int N = 4;
      int numSolns = mc.recursiveMakingChangeCount(data, data.length, N);
      System.out.println("Number of Possible Solutions: " + numSolns);

      // Recursive Example - minimum number of coins
      DPMakingChange mc2 = new DPMakingChange();
      int numMinCoinsRec = mc2.recursiveMakingChangeMinimunCoins(data, N);
      System.out.println("Number of Minimum Coin Solution Recursive: " + numMinCoinsRec);
      
      // Recursive Cache Example - minimum number of coins
      int[] cache = new int[N+1];
      for(int i=0; i<=N; i++)
         cache[i] = Integer.MAX_VALUE;     
      for(int c : data)
         cache[c] = 1;
      DPMakingChange mc3 = new DPMakingChange();
      int numMinCoinsRecCache = mc3.recursiveCacheMakingChangeMinimumCoins(data, N, cache);
      System.out.println("Number of Minimum Coin Solution Recursive Cache: " + numMinCoinsRecCache);
      
      // Dynamic Programming - Count minimum number of coins
      for(int i=0; i<=N; i++)
         cache[i] = Integer.MAX_VALUE;     
      for(int c : data)
         cache[c] = 1;
      DPMakingChange mc4 = new DPMakingChange();
      int numMinCoinsDP = mc4.dpMakingChangeMinimumCoins(data, N, cache);
      System.out.println("Number of Minimum Coin Solution DP: " + numMinCoinsDP);
   }
}
