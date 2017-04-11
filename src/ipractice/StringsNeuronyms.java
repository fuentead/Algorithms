package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Neuronym is a string that contains the 
 * count of number of letters between a set 
 * of letters.
 * 
 * Generate all possible Neuronyms for a given
 * string.
 * 
 * Nailed:
 * "n4d"
 * "na3d", "n3ed"
 * "n2led", "na2ed", "nai2d"
 * 
 * Print progressively longer strings
 */
public class StringsNeuronyms {
   
   public static void neuronymsPrintResults(String s, int istart, int iend) {
      for(int i=0; i<istart; i++)
         System.out.print(s.charAt(i));
      
      int cnt=0;
      for(int i=istart; i<iend; i++)
         cnt++;
      System.out.print(cnt);
      
      for(int i=iend; i<s.length(); i++)
         System.out.print(s.charAt(i));
      
      System.out.print(", ");
   }
   
   public static void neuronyms(String s,int istart, int iend) {
      
      if((iend-istart) <2)
         return;
      
      // If indices close to middle element, 
      // return to avoid repetition.
      int imid = s.length()/2;
      if(imid == (iend-1) && (imid-1)==istart) {
         return;
      }
      
      neuronymsPrintResults(s, istart, iend);     
      neuronyms(s, istart+1, iend);
      neuronyms(s, istart, iend-1);     
   }

   public static void neuronyms(String s) {
      if(s.length() == 0)
         return;
        
      int istart = 1;
      int iend = s.length()-1;
      
      neuronyms(s, istart, iend);
      
      if(s.length() % 2 == 0) {       
         int imid = s.length()/2;
         neuronymsPrintResults(s, imid-1, imid+1);
      }
   }

   public static void main(String[] args) {
      neuronyms("Nailed");
   }
}
