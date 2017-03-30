package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array of numbers, nums, return
 * an array of numbers products, where 
 * products[i] is the product of all 
 * nums[j], j != i
 * 
 * Input : [1, 2, 3, 4, 5]
 * Output: [(2*3*4*5),(1*3*4*5),(1*2*4*5),(1*2*3*5),(1*2*3*4)]
 * 
 * This must be done in O(N) time and constant space without 
 * using division. Usage of products array is not considered 
 * extra space.
 */
public class ArraysProduct {
   
   /*
    * Recursive result
    * Time Complexity: O(n)
    * Space Complexity: 
    */
   
   public static int product(int[] data, int prev, int index) {
      if(index >= data.length)
         return 1;
      
      int fwd = product(data, prev * data[index], index+1);
      int tmp = data[index];
      data[index] = prev * fwd;
      return fwd * tmp;
   }
   
   public static void arrayProduct(int[] data) {
      if(data.length == 0)
         return;      
      product(data, 1, 0);
   }
   
   /*
    * Division result
    * Time Complexity O(2n)
    * Space Complexity O(1)
    */
   public static void arrayProductD(int[] data) {
      if(data.length == 0)
         return;
      
      // Calculate total product result
      int totalP = 1;
      for(int i=0; i<data.length; i++) {
         totalP = totalP * data[i];
      }
      
      for(int i=0; i<data.length; i++) {
         int tmp = data[i];
         int res = totalP/tmp;
         data[i] = res;
      }  
   }
   
   public static void printData(int[] data) {
      for(int i=0; i<data.length; i++)
         System.out.print(data[i] + " ");
   }
   
   public static void main(String[] args) {
      int[] data = {1, 2, 3, 4, 5};
    
      System.out.println("Recursive Solution");
      arrayProduct(data);
      printData(data);
      
      int[] data1 = {1, 2, 3, 4, 5};
      System.out.println("\nDivision Solution");
      arrayProduct(data1);
      printData(data1);
   }
}
