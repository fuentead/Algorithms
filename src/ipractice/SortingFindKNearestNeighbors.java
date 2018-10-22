package ipractice;

import java.util.*;

public class SortingFindKNearestNeighbors {
   
   static class DistXY {
      int x;
      int y;
      int dist;
      public DistXY(int dist, int x, int y) {
         this.dist = dist;
         this.x = x;
         this.y = y;
      }
   }
   
   public static void findKNearestNeighbors(int[][] data, int[] p, int k) {
      if(data.length == 0)
         return;
      
      Queue<DistXY> maxHeap = new PriorityQueue<DistXY>(1, new Comparator<DistXY>() {
         public int compare(DistXY x, DistXY y) {
            return y.dist - x.dist;
         }
      });
      
      for(int i=0; i< data.length; i++) {
         int dist = (int) Math.sqrt(Math.pow(data[i][0] - p[0] , 2) + Math.pow(data[i][1] - p[1], 2));
         if(maxHeap.size() == k) {
            if(maxHeap.peek().dist > dist) {
               maxHeap.poll();
               maxHeap.add(new DistXY(dist, data[i][0], data[i][1])); 
            }
         }
         else 
            maxHeap.add(new DistXY(dist, data[i][0], data[i][1])); 
      }
      
      while(!maxHeap.isEmpty()) {
         DistXY val = maxHeap.poll();
         System.out.println(val.x + " " + val.y);
      }
   }

   public static void main(String[] args) {
      int[][] data = {{1,1}, {2,3},{5,5},{4,4}};
      int[] p = {0,0};
      findKNearestNeighbors(data, p, 2);
   }
}
