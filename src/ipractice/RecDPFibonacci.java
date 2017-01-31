package ipractice;

/**
 * @author Adriana Fuentes
 *
 */
public class RecDPFibonacci {
	
	/**
	 * Fibonacci series solved with dynamic programming 
	 * in constant space
	 * 
	 * Space Complexity O(1)
	 * Time Complexity O(n)
	 * @param Fibonacci number
	 */
	public static int dynamicFibonacciConstantSpace(int n) {
		int first = 0;
		int second = 1;
		int res = first;
		
		for(int i=2; i<=n; i++) {
			res = first + second;
			first = second;
			second = res;
		}
		
		return res;
	}
	
	/**
	 * Fibonacci series solved with dynamic programming
	 * 
	 * Space Complexity O(n)
	 * Time Complexity O(n)
	 * @param Fibonacci number
	 */
	public static int dynamicFibonacci(int n) {
		int[] cache = new int[n+1];
		for(int i=0; i<=n ; i++)
			cache[i] = -1;		
		cache[0] = 0;
		cache[1] = 1;
		
		for(int i=2; i<=n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		
		return cache[n];
	}
	
	/**
	 * Fibonacci series solved with recursion and cache
	 * 
	 * Space Complexity O(n)
	 * Time Complexity 2^n (2=number of calls)
	 * @param Fibonacci number
	 * 
	 * Example Problem n = 4
	 * 
	 * n = 4, index = n-1 = 3
	 * start cache = [-1,-1,-1,-1,-1]
	 * end cache = [0,1,1,2,3]
	 * 
	 * n = 3, index = n-1 = 2
	 * start cache = [-1,-1,-1,-1,-1]
	 * end cache = [0,1,1,2,-1]
	 * 
	 * n = 2, index = n-1 = 2
	 * start cache = [-1,-1,-1,-1,-1]
	 * end cache = [0,1,1,-1,-1]
	 * 
	 * n = 1, index = n-1 = 2
	 * start cache = [-1,-1,-1,-1,-1]
	 * end cache = [0,1,-1,-1,-1]
	 * 
	 * n = 0, index = n-1 = 2
	 * start cache = [-1,-1,-1,-1,-1]
	 * end cache = [0,-1,-1,-1,-1]
	 */
	public static int recursionCacheFibonacci(int n) {
		int[] cache = new int[n+1];
		for(int i=0; i<=n ; i++)
			cache[i] = -1;		
		cache[0] = 0;
		cache[1] = 1;
		
		return recursionCacheFibonacciHelper(n, cache);
	}
	
	public static int recursionCacheFibonacciHelper(int n, int[] cache) {

		if(n==0)
			return cache[0];
		if(n==1)
		    return cache[1];
			
		if(cache[n-1]==-1)
			cache[n-1] = recursionCacheFibonacciHelper(n-1, cache);
		if(cache[n-2]==-1)
			cache[n-2] = recursionCacheFibonacciHelper(n-2, cache);		
	
		cache[n] = cache[n-1] + cache[n-2];
		
		return cache[n];
	}
	
	
	/**
	 * Fibonacci series solved with recursion
	 * 
	 * Time Complexity
	 * @param fibonacci number
	 */
	public static int recursionFibonacci(int n) {
		if(n==0)
			return 0;
		if(n==1)
		    return 1;
		  
		 return recursionFibonacci(n-1) + recursionFibonacci(n-2);
	}

	
	public static void main(String[] args) {
		int n = 4;
		
		// Recursion Fibonacci
		int recF = recursionFibonacci(n);
		System.out.println("Fibonacci with Recursion: " + recF);
		
		int recCacheF = recursionCacheFibonacci(n);
		System.out.println("Fibonacci with Recursion & Cache: " + recCacheF);
		
		int dynF = dynamicFibonacci(4);
		System.out.println("Fibonacci with Dynamic Programming: " + dynF);
		
		int dynFConstantSpace = dynamicFibonacciConstantSpace(4);
		System.out.println("Fibonacci with Dynamic Programming and Constant Space: " + dynFConstantSpace);
	}
}
