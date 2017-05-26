package icakeproblems;

/**
 * @author Adriana Fuentes
 * 
 * Write a fibonnacci function that takes an integer nth 
 * and returns the nth fibonacci number.
 *
 * Fibonnaci numbers are: 1, 1, 2, 3, 5, 8, 13 ...
 * 
 * n=5, fib5= 5
 */
public class NthFibonacciNumber {

   /*
    * Recursion of Fibonacci numbers
    * Time Complexity: O(n)
    * Space Complexity: O(n) stack space usage because of recursion.
    */
   public int nthfibonacciRec(int n) {
      if(n == 0)
         return 1;
      else if(n==1)
         return 1;
      else {
         return nthfibonacciRec(n-1) + nthfibonacciRec(n-2);
      }
   }
   
   /*
    * Recursion with caching Fibonacci numbers
    */
   public int nthFibonacciRecCache(int n) {
      int[] cache = new int[n+1];
      
      for(int i=0; i<=n; i++) 
         cache[i] = -1;
      
      cache[0] = 1;
      cache[1] = 1;
      
      return nthFibonacciRecCacheHelper(n, cache);     
   }
   
   private int nthFibonacciRecCacheHelper(int n, int[] cache) {
      if(n == 0)
         return cache[0];
      else if(n==1)
         return cache[1];
      else {
         if(cache[n-1] != -1 && cache[n-2] != -1)
            cache[n] = cache[n-1] + cache[n-2];
         else 
            cache[n] = nthFibonacciRecCacheHelper(n-1, cache) + nthFibonacciRecCacheHelper(n-2, cache);         
        return cache[n];
      }      
   }
   
   /*
    * Caching with iteration - Dynamic Programming
    */
   public int nthFibonnacciDynamicP(int n) {
      int[] cache = new int[n+1];
      
      for(int i=0; i<=n; i++) 
         cache[i] = -1;
      
      cache[0] = 1;
      cache[1] = 1;
      
      return nthFibonnacciDynamicPHelper(n, cache);        
   }
   
   private int nthFibonnacciDynamicPHelper(int n, int[] cache) {
      if(n==0)
         return cache[0];
      else if(n==1)
         return cache[1];
      else {
         for(int i=2; i<=n; i++) {
            //if(cache[i-1] != -1 && cache[i-2] != -1)
               cache[i] = cache[i-1] + cache[i-2];
         }
      }
      return cache[n];
   }
   
   public static void main(String[] args) {
      int n = 5;
      NthFibonacciNumber f = new NthFibonacciNumber();
      int fnumrec = f.nthfibonacciRec(n);
      System.out.println(fnumrec);
      
      int fnumreccache = f.nthFibonacciRecCache(n);
      System.out.println(fnumreccache);
      
      int fnumdyn = f.nthFibonnacciDynamicP(n);
      System.out.println(fnumdyn);
   }
}
