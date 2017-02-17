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
   
   public static void printSubsetsOfSetHelper(char[] set, int index, boolean notFirst) {
      if(index >= set.length)
         return;
      
      if(!notFirst) 
         notFirst = true;
      else 
         System.out.print(", ");
      
      System.out.print(set[index]);    
      printSubsetsOfSetHelper(set, index+1, true);
   }

   public static void printSubsetsOfSet(char[] set) {
      if(set.length == 0)
         return;  
       
      System.out.print("{{},");
      for(int i=0; i<set.length-1; i++) {
         System.out.print("{" + set[i]+"},{");
         printSubsetsOfSetHelper(set, i, false); 
         System.out.print("},");
      }
      System.out.println("{" + set[set.length-1] + "}" + "}");
   }
   
   public static void main(String[] args) {
      char[] set = {'x', 'y'};
      printSubsetsOfSet(set);
      
      char[] set2 = {'1', '2', '3'};
      printSubsetsOfSet(set2);
   }
}
