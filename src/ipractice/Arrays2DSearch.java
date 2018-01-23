package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Find a number in a sorted 2D array.
 * 
 * Given a 2d array (NxM) where
 * all the numbers (integers) in the array
 * are in increasing order from left to right
 * and top to bottom. You are also given a 
 * target number, to be searched inside the
 * array. What is the best way to search and 
 * determine if a number is in the array.
 */
public class Arrays2DSearch {
   
   /*
    * Search 2D array to find k
    * Time Complexity O(n)
    * Space Complexity O(1)
    * 
    * Algorithm: Start checking from the
    * top right most corner and move down 
    * or left as needed.
    */
   public static boolean twoDimensionalSearchConstantTime(int[][] data, int k) {
      int i = 0;
      int j = data[0].length-1;
      
      while(i < data.length && j >=0) {
         if(data[i][j] == k)
            return true;
         else if (data[i][j] > k) 
            j--;
         else 
            i++;  
      }
      return false;
   }

   /*
    * Search 2D array to find k
    * Time Complexity O(n*m)
    * Space Complexity O(1)
    */
   public static boolean twoDimensionalSearch(int[][] data, int k) {      
      if(data.length == 0)
         return false;
      
      for(int i=0; i<data.length; i++) {
         for(int j=0; j<data[i].length; j++) {
            if(data[i][j] == k)
               return true;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      int[][] data = {{1,2,3,4},{5,7,8,9},{6,10,11,12}};
      boolean result = twoDimensionalSearch(data, 9);
      System.out.println(result);
      
      boolean result2 = twoDimensionalSearchConstantTime(data, 10);
      System.out.println(result2);
   }
}
