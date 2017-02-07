package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Count recursively the total number of "abc" and "aba" 
 * substrings that appear in the given string.
 * 
 * countAbc("abc") → 1
 * countAbc("abcxxabc") → 2
 * countAbc("abaxxaba") → 2
 */
public class RecCountAbc {

   /*
    * Count ABC and ABA problem solved recursively.
    * 
    * Time Complexity O(n)
    * Space Complexity O(n), stack for recursion
    */
   public static int recCountAbcHelper(String s, int index) {
      if(index == s.length()-1)
         return 0;
      else if(s.charAt(index) == 'a' && s.charAt(index+1) == 'b') {
            if(s.charAt(index+2) == 'c' || s.charAt(index+2) == 'a')
               return 1 + recCountAbcHelper(s, index+1);
            else 
               return recCountAbcHelper(s, index+1);
      }
      else
         return recCountAbcHelper(s, index+1);
   }
   
   public static int recCountAbc(String s) {
      if(s.length() == 0)
         return 0;
      else 
         return recCountAbcHelper(s, 0);
   }
   
   public static void main(String[] args) {
      int res1 = recCountAbc("abc");
      System.out.println(res1);
      
      int res2 = recCountAbc("abcxxabc");
      System.out.println(res2);
      
      int res3 = recCountAbc("abaxxaba");
      System.out.println(res3);
   }
}
