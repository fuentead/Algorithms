package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given two words word1 and word2, find the minimun number of 
 * steps required to convert word1 to word2. (each operation 
 * is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * e.g. Minimum edit distance between words 'kitten' and 'sitting' is 3.
 * 
 *  - kitten -> sitten (substitution of "s" for "k")
 *  - sitten -> sittin (substitution of "i" for "e")
 *  - sittin -> sitting (insertion of "g" and end)
 *  
 *  (Assume all inputs and substitutions in lower case)
 *  
 */
public class DPLevenshteinEditDistance {
   
   private int minimumDistance(int insertCnt, int removeCnt, int replaceCnt) {
      int min = insertCnt;
      if (removeCnt < min) 
         min = removeCnt;
      else if (replaceCnt < min)
         min = replaceCnt;
      
      return min;
   }

   /* 
    * Recursive way to solve edit distance problem.
    * 
    * Time Complexity: O(n)
    * Space Complexity: stack usage of n
    */
   public int calculateEditDistanceRec(String w1, String w2, int w1len, int w2len) {
      // If first string is empty, insert characters from first string to second string.
      if(w1len == 0)
         return w2len;
      
      // If second string is empty, insert characters from second string to first string.
      else if(w2len == 0)
         return w1len;
      
      // If last character of first string and second string are the same, ignore and move to the next character.
      else if(w1.charAt(w1len-1) == w2.charAt(w2len-1)) 
         return calculateEditDistanceRec(w1, w2, w1len-1, w2len-1);
      // Calculate the minimum from insert, remove and replace to w1
      else {
         return 1 + minimumDistance(calculateEditDistanceRec(w1, w2, w1len, w2len-1),  // insert
                                    calculateEditDistanceRec(w1, w2, w1len-1, w2len),  // remove
                                    calculateEditDistanceRec(w1, w2, w1len, w2len-1)); // replace
      }        
   }
   
   public static void main(String[] args) {
      DPLevenshteinEditDistance d = new DPLevenshteinEditDistance();
      String w1 = "kitten";
      String w2 = "sitting";
      int editDistanceRec = d.calculateEditDistanceRec(w1, w2, w1.length(), w2.length());
      System.out.println("Edit Distance 1: " + editDistanceRec);
      
   }
}
