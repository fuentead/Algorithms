package ipractice;

/**
 * @author adrianafuentes
 * 
 * Given a string, compute recursively the number of times lowercase 
 * "hi" appears in the string, however do not count "hi" that have 
 * an 'x' immedately before them.
 * 
 * countHi2("ahixhi") → 1
 * countHi2("ahibhi") → 2
 * countHi2("xhixhi") → 0
 */
public class RecCountHi2 {
   
   public static int recCountHi2Helper(String s, int index, char prev) {
      if(index >= s.length()-1)
         return 0;
      else {
         if(s.charAt(index) == 'h' && s.charAt(index+1) == 'i' && prev != 'x')
            return 1 + recCountHi2Helper(s, index+2, s.charAt(index+1));
         else
            return recCountHi2Helper(s, index+1, s.charAt(index));       
      }
   }

   public static int recCountHi2(String s) {
      if(s.length() ==0)
         return 0;
      else 
        return recCountHi2Helper(s, 0, '*');
   }
   
   public static void main(String[] args) {
      int res = recCountHi2("ahixhi");
      System.out.println(res);

      int res2 = recCountHi2("ahibhi");
      System.out.println(res2);
      
      int res3 = recCountHi2("xhixhi");
      System.out.println(res3);
   }

}
