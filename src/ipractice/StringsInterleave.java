package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * --- 
 * Find if two strings interleave.
 * ---
 */

public class StringsInterleave {

   public static boolean stringsInterleave(String s1, String s2, String S) {
      if(s1.length() + s2.length() != S.length())
         return false;
      
      int M = s1.length();
      int N = s2.length();
      boolean[][] table = new boolean[M+1][N+1];
      
      for(int i=0; i<=M; i++) {
         for(int j=0; j<=N; j++) {  
            System.out.println("i: " + i + "j: " + j);
            // If both strings are empty, then it could be empty
            if(i==0 && j==0)
               table[i][j] = true;
            // char at s1 matches char at S
            else if(j==0 && s1.charAt(i-1) == S.charAt(i-1))
               table[i][j] = table[i-1][j]; 
            // char at s2 matches char at S
            else if(i==0 && s2.charAt(j-1) == S.charAt(j-1))
               table[i][j] = table[i][j-1];
            // char at s2 matches char at S in i+j-1 distance
            else if(s2.charAt(j-1) == S.charAt(i+j-1) && s1.charAt(i-1) != S.charAt(i+j-1))
               table[i][j] = table[i][j-1];
            // char at s1 matches char at S in i+j-1 distance
            else if(i!=0 && s1.charAt(i-1) == S.charAt(i+j-1) && s2.charAt(j-1) != S.charAt(i+j-1))
               table[i][j] = table[i-1][j]; 
            // both char at s2 and s1 match char at S in i+j-1 distance
            else if(j!=0 && s2.charAt(j-1) == S.charAt(i+j-1) && s1.charAt(i-1) == S.charAt(i+j-1))
               table[i][j] = table[i-1][j] || table[i][j-1];
         }
      }
      return table[M][N];
   }
   
   public static void main(String[] args) {
      String s1 = "xxx";
      String s2 = "yyy";
      String S = "xxxyyy";
      boolean res = stringsInterleave(s1, s2, S);
      System.out.println(res);
      
      String s1b = "zzmmzz";
      String s2b = "aabbbb";
      String Sb = "zzmmzzaabbbb";
      boolean res2 = stringsInterleave(s1b, s2b, Sb);
      System.out.println(res2);
   }
}
