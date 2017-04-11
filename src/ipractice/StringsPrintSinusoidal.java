package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Problem is also called "SnakeString".
 * Word separators should be printed with '~'.
 */
public class StringsPrintSinusoidal {
   

   public static void printStringSinusoidally(String s) {
      if(s.length() == 0)
         return;
      
      //Print first line
      int i=2;
      System.out.print("   " + s.charAt(i));
      i=i+4;
      while(i <s.length()) {         
         if(s.charAt(i) == ' ')
            System.out.print("     " + "~");
         else
            System.out.print("     " + s.charAt(i));
         i=i+4;
      } 
      System.out.println("");
      
      // Print second line
      i=1;
      System.out.print(" " + s.charAt(i));
      i=i+2;
      while(i<s.length()) {
         if(s.charAt(i) == ' ')
            System.out.print("  " + "~");
         else
            System.out.print("  " + s.charAt(i));
         i=i+2;
      }
      System.out.println("");
      
      // Print third line
      i=0;
      System.out.print(s.charAt(i));
      i=i+4;
      while(i<s.length()) {
         if(s.charAt(i) == ' ')
            System.out.print("     " + "~");
         else
            System.out.print("     " + s.charAt(i));
         i=i+4;
      }      
   }
   
   public static void main(String[] args) {
      String s = "Google Worked";
      printStringSinusoidally(s);
   }
}
