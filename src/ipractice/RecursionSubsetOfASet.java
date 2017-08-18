package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Print all subsets of a set.
 * 
 * E.g.
 * {x,y} => {{},{x},{y},{x,y}} 
 * Since we are working with sets {y,x} is not different from {x,y}. 
 * {x,x} is not a valid subset, unless the input also has two x's.
 * 
 * {1,2,3} => {{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}}
 * 
 * Input: Set, as an array.
 * Output: Subsets in any order.
 * 
 */
public class RecursionSubsetOfASet {
   
   public static void subsetsSet(char[] set) {
      if(set.length == 0)
         return;
      System.out.print("{");
      subsetsSetHelper(set, new StringBuilder(), 0);
      System.out.print("}\n");
   }
   
   private static void subsetsSetHelper(char[] set, StringBuilder included, int index) {
      if(index >= set.length) {
         System.out.print("{" + included.toString() + "}");
         return;
      }
       
      subsetsSetHelper(set, included, index+1);
      included.append(set[index]);
      subsetsSetHelper(set, included, index+1);
      included.deleteCharAt(included.length()-1);
   }
   
   public static void main(String[] args) {
      char[] set = {'x', 'y'};
      subsetsSet(set);
      
      char[] set2 = {'1', '2', '3'};
      subsetsSet(set2);
   }
}
