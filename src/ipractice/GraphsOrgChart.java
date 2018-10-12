package ipractice;

import java.util.*;

public class GraphsOrgChart {

   public static void printOrgChart(List<String> data) {
      if(data.size() == 0)
         return;
      
      Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
      for(int i=0; i<data.size(); i++) {
         String s = data.get(i);
         String emp = s.substring(2);
         
         List<Character> l = new ArrayList<Character>();
         int iemp = 0;
         while(iemp<emp.length()) {           
            l.add(emp.charAt(iemp));
            iemp = iemp + 2;
         }
         System.out.println(l);
         map.put(s.charAt(0), l);
      }
      
      char c = data.get(0).charAt(0);
      System.out.println(c);
      List<Character> s = map.get(c);
      StringBuilder sb = new StringBuilder();
      sb.append("---");
      printOrgChartR(map, s, 0, sb);      
   }
   
   private static void printOrgChartR(Map<Character, List<Character>> map, List<Character> empL, int index, StringBuilder sb) {
      if(index >= empL.size())
         return;
      
      System.out.print(sb.toString());
      System.out.println(empL.get(index));
      
      if(map.containsKey(empL.get(index))) {         
         sb.append("---");
         List<Character> l = map.get(empL.get(index));
         printOrgChartR(map, l, 0, sb);
      }      
      printOrgChartR(map, empL, index+1, sb);
      if(sb.length() >= 3) {
         sb.delete(sb.length()-3, sb.length());
      }
   }

   public static void main(String[] args) {
      List<String> data = new ArrayList<String>(Arrays.asList("A,B,C,D",
                           "B,E,F",
                           "F,G,H",
                           "H,I"));                              
      printOrgChart(data);                           
   }
}
