package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * L10n is a neuronym of the word "Localization"
 * 10 stands for the number of letters between the
 * first 'L' and the last 'n' in the word. 
 * 
 * Generate all such possible Numeronyms for any
 * given string (character array).
 * 
 * "Nailed":
 * "n4d"
 * "na3d", "n3ed"
 * "n2led", "na2ed", "nai2d"
 * 
 * e.g. for the word "batch"
 * "b3h"
 * "ba2h", "b2ch"
 * 
 * Print strings in progressive order of longer strings.
 * Stop when there are 2s.
 * 
 */
public class ArraysNeuronyms {
   
   public static void neuronyms(String s, int totalK, int leftK, int rightK) {
      if(rightK < 1)
         return;
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<leftK; i++) {
         sb.append(s.charAt(i));
      }
      
      int numberLetters = s.length() - totalK;
      sb.append(Integer.toString(numberLetters));
      
      for(int i=s.length()-rightK; i<s.length(); i++) {
         sb.append(s.charAt(i));
      }
      
      System.out.print(sb.toString() + " ");
      neuronyms(s, totalK, leftK+1, rightK-1);
   }

   public static void neuronyms(String s) {
      if(s.length() < 4)
         return;

      int totalK=2; // Total letters to print
      while(s.length() - totalK >= 2) {         
         neuronyms(s, totalK, 1, totalK-1);
         System.out.print('\n');
         totalK++;
      }     
   }

   public static void main(String[] args) {
      System.out.println("Results for 'nailed'");
      neuronyms("nailed"); 
      
      System.out.println("\nResults for 'batch'");
      neuronyms("batch"); 
   }
}
