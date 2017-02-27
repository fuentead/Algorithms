package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a string of integers as input, put between
 * each pair of digits, one of {"", "*", "+"} such
 * that the expression you get will evaluate to K
 * (a number also given as input). Putting an empty
 * string ("") between two numbers means, that the 
 * numbers are joined to form a new number (e.g. 1""2=12)
 * 
 * Order of integers given as input needs to remain the
 * same.
 * 
 * Input:
 * 1) String of positive integers
 * 2) Target K (given constant)
 * 
 * Output: all possible strings that evaluate to K
 * 
 * Precedence of operators matters. In higher to lower
 * precedence.
 * 1. Join ("")
 * 2. Multiplication (*)
 * 3. Addition (+)
 * 
 * If the input is "222" and the answer is "24", two possible
 * options are:
 * 
 * 1. 22+2
 * 2. 2+22
 * 
 */
public class RecursionExpressionEvaluator {
   
   public static int expressionSynthesis(String s) {
      if(s.length() == 0)
         return 0;
      else if(s.length() == 1)
         return Integer.parseInt(s);
      
      if(s.contains("+")) {
         int j = s.indexOf("+");
         String substr1 = s.substring(0, j);
         String substr2 = s.substring(j+1, s.length());
         
         int res1 = expressionSynthesis(substr1);
         int res2 = expressionSynthesis(substr2);
         int res = res1 + res2;
         return res;
      }
      else if(s.contains("*")) {
         int j = s.indexOf("*");
         String substr1 = s.substring(0, j);
         String substr2 = s.substring(j+1, s.length());
         
         int res1 = expressionSynthesis(substr1);
         int res2 = expressionSynthesis(substr2);
         int res = res1 * res2;
         return res;
      }
      else
         return Integer.parseInt(s);
   }
   
   public static void expressionEvaluatorHelper(String s, int k, int index, StringBuilder sb, List<String> results) {
      // Evaluate expressions
      if(index > (s.length()-1)) {
         String res = sb.toString();
         int valRes = expressionSynthesis(res);
         if(valRes == k) 
           results.add(res +"="+ k);
         return;
      }      
      
      // Create expressions 
      sb.append("" + s.charAt(index));
      expressionEvaluatorHelper(s, k, index+1, sb, results);
      sb.deleteCharAt(sb.length()-1);    
      
      sb.append("+" + s.charAt(index));
      expressionEvaluatorHelper(s, k, index+1, sb, results);
      sb.delete(sb.length()-2,sb.length());

      sb.append("*" + s.charAt(index));
      expressionEvaluatorHelper(s, k, index+1, sb, results);
      sb.delete(sb.length()-2,sb.length());
   }
   
   public static String[] expressionEvaluator(String s, int k) {
      List<String> results = new ArrayList<String>();
      if(s.length() == 0)
         return results.toArray(new String[results.size()]);      
      
      StringBuilder sb = new StringBuilder();
      expressionEvaluatorHelper(s, k, 1, sb.append(s.charAt(0)), results);
      
      return results.toArray(new String[results.size()]);
   }
   
   public static void main(String[] args) { 
      String[] results = expressionEvaluator("222", 24);
      System.out.println("Results:");
      for(int i=0; i<results.length; i++)
         System.out.println(results[i]);
   }
}
