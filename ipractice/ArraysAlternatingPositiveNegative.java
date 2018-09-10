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

   /*public static void alternatingPositiveNegative(int[] data) {
      if(data.length == 0)
         return;
      
      int pos, neg, change;
      change =-1;
      boolean inextPos;
      int i = 0;     
      if(data[i] > 0) {
         pos = i;
         neg = -1;
         inextPos = false;
      }
      else {
         neg = i;
         pos = -1;
         inextPos = true;
      }
      
      i++;
      while(i < data.length) {
         System.out.println("i: " + i + " change: " + change + " inextPos: " + inextPos + " neg " + neg + " pos " + pos);
         if((inextPos == true) && (data[i] < 0)) {
            if(change == -1) {
               change = i;
               i++;
            }
         }
         else if((inextPos == true) && (data[i]>0)) {
            if(change == -1) {
               pos = i;
               i++;
            }
            else {
               swap(data, change, i);
               pos = change;
               change = -1;
            }
            inextPos = false;
         }
         else if((inextPos == false) && (data[i] > 0)) {
            if(change == -1)
               change = i;
            i++;
         }
         else {
            if(change != -1) {
               swap(data, change, i);
               neg = change;
               change = -1;
            }
            else {
               neg = i;
               i++;
            }
            inextPos = true;
         } 
      }
      if(change == -1)
         i++;
   }*/
   
   static class Stage {
      int istage1;
      int istage2;
      int size;
      Stage() {
         this.size = 0;
      }
   }
   
   private static void alternatingPositiveNegative(int[] data) {
      if(data.length == 0)
         return;
      
      int inextPos=-1;
      int inextNeg=-1;
      int inextPosVal=0;
      int inextNegVal=0;
      
      // Find first negative value
      inextNeg = findinextNeg(data, 0);
      inextNegVal = data[inextNeg];
      
      // Find first positive value
      inextPos = findinextPos(data, 0);
      inextPosVal = data[inextPos];
      
      Stage s = new Stage();
      for(int i=0; i<data.length && i+1<data.length; i=i+2) {
         System.out.println("inextNeg: " + inextNeg + " inextPos: " + inextPos);
         System.out.println("Prev: stage1 " + s.istage1 + " stage2 " + s.istage2);
         
         // Setup staging area
         s.istage1 = i;
         data[i] = 0;
         if(i+1 < data.length) {
            s.istage2 = i+1;         
            data[i+1] = 0;
         }
         System.out.println("After: stage1 " + s.istage1 + " stage2 " + s.istage2);
         // Setup array with inextPos && inextNeg
         
         data[i] = inextPosVal;
         if(inextPos == s.istage1)
            s.istage1 = 0;
         else if(inextPos == s.istage2)
            s.istage2 = 0;
         inextPos = 0;  
         inextPosVal = 0;

         data[i+1] = inextNegVal;
         if(inextNeg == s.istage1)
            s.istage1 = 0;
         else if(inextNeg == s.istage2)
            s.istage2 = 0;
         inextNeg = 0;
         inextNegVal = 0;
         
         if((data[s.istage1] == data[i]) || (data[s.istage1] == data[i+1]))
            s.istage1 = 0;
         else if((data[s.istage2] == data[i]) || data[s.istage2] == data[i+1])
            s.istage2 = 0;
         System.out.println("pos data " + data[inextPos] + " neg data " + data[inextNeg]);
         // Find next positive and negative
         // Look in staging area
         if(data[s.istage1] > 0) {
            inextPos = s.istage1;
            inextPosVal = data[inextPos];
         }
         else if(data[s.istage2] > 0) {
            inextPos = s.istage2;
            inextPosVal = data[inextPos];
         }
         else if(data[s.istage1] < 0) {
            inextNeg = s.istage1;
            inextNegVal = data[inextNeg];
         }
         else if(data[s.istage2] < 0) {
            inextNeg = s.istage2;
            inextNegVal = data[inextNeg];
         }
         
         if(inextPos == 0 && (i+3) < data.length)
            inextPos = findinextPos(data, i+3);
         if(inextNeg == 0 && (i+3) < data.length)
            inextPos = findinextNeg(data, i+3); 
      }
   }
   
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
   
   public static void main(String[] args) {
      
      int[] data = {-5,-4,9,-3,2};
      for(int i=0; i<data.length; i++)
         System.out.print(data[i] + " ");
      
      alternatingPositiveNegative(data);
      for(int i=0; i<data.length; i++)
         System.out.print(data[i] + " ");
   }
}
