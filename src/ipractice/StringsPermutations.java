package ipractice;


/**
 * @author Adriana Fuentes
 *
 * Generate the permutations of a string.
 */

public class StringsPermutations {
   
   public static void stringPermutations(String s) {
      if(s.length() == 0) {
         System.out.println("No permutations");
         return;
      }
      char[] cstring = s.toCharArray();
      stringPermutationsHelper(cstring, 0);
   }
   
   private static void stringPermutationsHelper(char[] cstring, int ilevel) {
      if(ilevel >= cstring.length) {
         System.out.println(new String(cstring));
         return;
      }
      for(int i=ilevel; i<cstring.length; i++) {
         swap(cstring, ilevel, i);
         stringPermutationsHelper(cstring, ilevel+1);
         swap(cstring, ilevel, i);
      }   
   }
   
   private static void swap(char[] cstring, int ilevel, int i) {
      char tmp = cstring[ilevel];
      cstring[ilevel] = cstring[i];
      cstring[i] = tmp;
   }

   public static void main(String[] args) {
      stringPermutations("cat");
   }
}
