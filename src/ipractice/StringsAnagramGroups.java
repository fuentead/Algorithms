package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 */
public class StringsAnagramGroups {

   /* 
    * N=> size array, M=> size string
    * Time Complexity: O(N*MlogM) 
    * Space Complexity: O(N)
    */
   public static void anagramGroups(String[] data) {
      if(data.length == 0)
         return;

      Map<Integer, List<String>> groupsMap = new HashMap<>();
      for(int i=0; i<data.length; i++) {

        // Sort word and convert to hashcode 
        char[] strCharArray = data[i].toCharArray();
        Arrays.sort(strCharArray);
        String s = Arrays.toString(strCharArray);
        int hashCode = s.hashCode();
        
        // Group words in hashmap
        if(groupsMap.containsKey(hashCode)) {
           List<String> l = groupsMap.get(hashCode);
           l.add(data[i]);
           groupsMap.put(hashCode, l);
        }
        else {
           List<String> l = new ArrayList<String>();
           l.add(data[i]);
           groupsMap.put(hashCode, l);
        }
      } 
      
      // Print results
      int groupCount = 0;
      for(List<String> list : groupsMap.values()) {
         System.out.print("\nGroup " + groupCount + ": ");
         for(String s : list)
            System.out.print(s + " ");
         groupCount++;
      }
   }
   
   public static void main(String[] args) {
      String[] data = {"eat", "tea", "tan", "ate", "nat", "bat"};
      anagramGroups(data);
   }
}
