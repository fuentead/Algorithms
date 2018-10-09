package ipractice;

public class ArraysMissingElement {

   public static int missingElement(int[] data) {
      if(data.length == 0)
         return -1;
      
      int i=0;
      while(i<data.length) {
         if(i+1 != data[i])
            return i+1;
         i++;
      }
      return -1;
   }

   public static void main(String[] args) {
      int[] data = {1,2,3,5,5};
      int res = missingElement(data);
      System.out.println(res);
   }
}
