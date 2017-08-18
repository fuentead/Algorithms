package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Double Power:
 * Implement a power function to raise a double to 
 * an int power, including negative powers using
 * recursion.
 * 
 * e.g. pow(double d, int p) should give 'd' raised 
 * to power 'p'
 * 
 */
public class RecursionDoublePower {
   
   /*
    * Solution of Double Power with recursion.
    * 
    * Time Complexity: O(n), one option for recursion.
    * Space Complexity: O(1), due to 
    *                  recursive stack usage is O(n)
    */
   public static double doublePower(double d, int p) {
      if(p == 0)
         return 1;
      else if(p > 0)
         return d * doublePower(d, p-1);
      else
         return 1/d*doublePower(d, p+1);
   }

   public static void main(String[] args) {
      double res = doublePower(3,2);
      System.out.println(res);
      
      double res2 = doublePower(4.5,-3);
      System.out.println(res2);
   }
}
