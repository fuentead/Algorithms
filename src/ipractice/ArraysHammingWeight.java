package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a large array of 4-byte integers, 
 * write a method to find how many total 
 * bits are turned on (i.e. 1s are set)
 * inside such an array [Such a digital sum of
 * binary representation of a number, is also 
 * called its Hamming Weight].
 * 
 * e.g. 
 * 1. If input array has two numbers: 31 and 51, 
 * the answer is 9 because 31 has 5 bits turned on
 * (out of 32) and 51 has 4.
 * 
 * 2.If input is 2147483647 and 3, the answer is 
 * 31 + 2 = 33
 * 
 * Looking for a fast solution, even with extra memory. 
 */
public class ArraysHammingWeight {
   
   /* Convert Decimal To Binary
    * Approach 1: Integer.toBinaryString() function
    * 
    * Approach 2: Divide number by 2 until reach 0.
    * Results will be binary number.
    */
   public static String convertDecimalToBinary(int number) {
      StringBuffer binary = new StringBuffer();
      
      if(number>=0 && number<2) 
         binary.append(Integer.toString(number));         

      while(number > 0) {
         int rem = number % 2;
         number = number / 2;
         binary.insert(0,rem);
      }
      return binary.toString();
   }
   
   public static int countBinaryBitsOn(int number) {
      Map<Integer,Integer> bitsCountMap = new HashMap<Integer, Integer>();
      if(number < 2) {
         if(number == 1)
            return 1;
         else
            return 0;
      }
      
      bitsCountMap.put(1, 0);
      bitsCountMap.put(0, 0);
      
      while(number > 0) {
         int rem = number % 2;
         number = number / 2;
         int count = bitsCountMap.get(rem);
         count++;
         bitsCountMap.put(rem, count);
      }      
      return bitsCountMap.get(1);
   }
   


   public static void main(String[] args) {
      String binary = convertDecimalToBinary(7);
      System.out.println(binary);
      
      int countBitsOn = countBinaryBitsOn(7);
      System.out.println(countBitsOn);
   }
}
