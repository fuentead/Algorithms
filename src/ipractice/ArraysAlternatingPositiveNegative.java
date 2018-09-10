package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array containing both positive and negative
 * integers, return an array of alternating positive 
 * integers and negative integers such that each set
 * of integers are in the same order as in the input 
 * array (stable).
 * 
 * input {2,3,-4,-9,-1,-7,1,-5,-6}
 * output {2,-4,3,-9,1,-1,-7,-5,-6}
 * 
 * Implement it without using any additional space.
 */
public class ArraysAlternatingPositiveNegative {
   
   public static int findinextPos(int[] data, int istart) {  
      System.out.println();
      while(istart < data.length-1 && data[istart] < 0)
         istart++;
      return istart;         
   }
   
   public static int findinextNeg(int[] data, int istart) {
      while(istart < data.length-1 && data[istart] > 0)
         istart++;
      return istart;
   }
   
   private static void swap(int[] data, int aindex, int bindex) {
      int tmp = data[aindex];
      data[aindex] = data[bindex];
      data[bindex] = tmp;
   }
   
   public static void alternateposneg(int[] data) {
      if(data.length == 0)
         return;
      
      int ipos=0;
      int ineg=0;
      int i=0;
      while(i<data.length) {
         if((i%2==0) && (data[i]<0)) {
               ipos = findinextPos(data, ipos);
               swap(data, i, ipos);            
         }
         else if((i%2!=0) && (data[i]>0)) {
               ineg = findinextNeg(data,ineg);
               swap(data, i, ineg);           
         }
         i++;
      }  
   }
   
   public static void main(String[] args) {
      
      int[] data = {-5,-4,9,-3,2,6};
      
      alternateposneg(data);
      for(int i=0; i<data.length; i++)
         System.out.print(data[i] + " ");
   }
}
