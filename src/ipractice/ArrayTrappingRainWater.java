package ipractice;

public class ArrayTrappingRainWater {

   public static int rainWater(int[] data) {
      if(data.length < 3)
         return 0;
      
      int size = data.length;
      int[] leftMaxH = new int[size];
      int[] rightMaxH = new int[size];
      
      leftMaxH[0] = data[0];
      for(int i=1; i<size; i++)
         leftMaxH[i] = Math.max(leftMaxH[i-1], data[i]);
      
      rightMaxH[size-1] = data[size-1];
      for(int i=size-2; i>=0; i--)
         rightMaxH[i] = Math.max(rightMaxH[i+1], data[i]);
      
      int sum=0;
      for(int i=1; i<size; i++)
         sum = sum + Math.min(leftMaxH[i], rightMaxH[i]) - data[i];
      
      return sum;
   }

   public static void main(String[] args) {
      int[] data = {3,0,0,2,0,4};
      int res = rainWater(data);
      System.out.println(res);
   }
}
