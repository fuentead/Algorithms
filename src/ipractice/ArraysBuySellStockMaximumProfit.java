package ipractice;

/**
 * @author Adriana Fuentes
 * 
 */

public class ArraysBuySellStockMaximumProfit {

   public static int maximizeProfitStock(int[] data) {
      if(data.length <2)
         return -1;
      
      int min = Integer.MAX_VALUE;
      int maxProfit = 0;
      for(int i= 0; i<data.length; i++) {
         if(data[i] < min)
            min = data[i];
         int diff = data[i] - min;
         if(diff > maxProfit)
            maxProfit = diff;
      }
      return maxProfit;
   }

   public static void main(String[] args) {
      int[] stockPrices = {3, 5, 1, 7, 6, 30};
      int maxProfit = maximizeProfitStock(stockPrices);
      System.out.println(maxProfit);
   }
}
