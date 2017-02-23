package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * A disorganized carpenter has a mixed pile of bolts and nuts
 * and would like to find the corresponding pairs of bolts and 
 * nuts. Each nut matches exactly one bolt. (And vice versa). 
 * By trying to match a bolt and a nut the carpenter can see 
 * which one is bigger but she cannot compare two bolts or nuts
 * directly. Write an algorithm to match each nut to bolt.
 * 
 * Assumptions:
 * Equal number of nuts and bolts.
 * A given nut uniquely matches a bolt. There are not unmatched nuts 
 * or bolts.
 * 
 * Input: 
 * N3, N2, N1, N4
 * B4, B2, B3, B1
 * 
 * Output:
 * N1B1
 * N2B2
 * N3B3
 * N4B4
 */
public class SortingNutsAndBolts {
   
	/*
	 * Bolts and nuts using recursion
	 * 
	 * Time Complexity: 
	 * Space Complexity:
	 */
   public static void matchNutsBoltsHelper(String[] nuts, String[] bolts, int index) {    
      int i = index;      
      while(i != nuts.length-1) {
         if((int) nuts[i].charAt(1) < (int) bolts[index].charAt(1))
            i++;
         if(nuts[i].charAt(1) == bolts[index].charAt(1)) {
            swap(nuts,i,index);
            matchNutsBoltsHelper(nuts, bolts, index+1);
            return;
         }
      }
   }
   
   /*
    * Swap content in nuts with bolts index so they can match
    */
   public static void swap(String[] nuts, int inuts, int ibolts) {
      String temp = nuts[ibolts];
      nuts[ibolts] = nuts[inuts];
      nuts[inuts] = temp;
   }

   public static void matchNutsBolts(String[] nuts, String[] bolts) {
      if(nuts.length != bolts.length || nuts.length == 0)
         return;
      
     matchNutsBoltsHelper(nuts, bolts, 0);     
   }
   
   public static void main(String[] args) {
      String[] nuts = {"N3", "N2", "N1", "N4"};
      String[] bolts = {"B4", "B2", "B3", "B1"};
      
      matchNutsBolts(nuts, bolts);
      
      for(int i=0; i< nuts.length; i++) {
         System.out.println(nuts[i] + bolts[i]);
      }      
   }
}
