package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Sorting Nearest Neighbor
 * 
 * Given a point P, and other N points in two dimensional
 * space, find K points out of the N points which are 
 * nearest to P.
 * 
 * *Distance between two points is measured by standard 
 * eucledian distance formula
 * 
 * d(x,y) = sqrt((y2 - y1)^2 + (x2 - x1)^2)
 *  
 */
public class SortingNearestNeighbor {
   
   static class Tuple {
      int x;
      int y;
      double distance;
      Tuple(int x, int y) {
         this.x = x;
         this.y = y;
         this.distance = -1;
      }
   }

   /*
    * Formula to calculate Euclidean distance
    */
   public static double euclideanDistanceMethod(Tuple target, Tuple n) {
      if(target == null || n == null)
         return -1;
      
      double rpower = Math.pow((n.y - target.y), 2) + Math.pow(n.x - target.x, 2);   
      double distance = Math.sqrt(rpower);
      
      return distance;
   }

   /*
    * Using a Max Heap to find the numbers that are closest to the point.
    */
   public static Queue<Tuple> findKNearestNeighborsHeap(Tuple target, int k, Tuple[] npoints) {
      
      Queue<Tuple> maxHeap = new PriorityQueue<Tuple>(1, new Comparator<Tuple>() {
         public int compare(Tuple x, Tuple y) {
            return (int)(y.distance - x.distance);
         }
      });
      
      // Find Eucledian distances
      for(int i=0; i<npoints.length; i++) {
         npoints[i].distance = euclideanDistanceMethod(target, npoints[i]);
      }     
      
      // Using a heap to find solution
      for(int i=0; i<npoints.length; i++) {                  
         if(maxHeap.size() < k) {
            maxHeap.add(npoints[i]);
         }
         else {
            if(maxHeap.peek().distance > npoints[i].distance) {
               maxHeap.poll();
               maxHeap.add(npoints[i]);
            }
         }
      } 
      return maxHeap;
   }
   
   /*
    * Using quicksort to find nearest neighbors
    */
   public static Tuple[] findNearestNeighborsQuicksort(Tuple target, int k, Tuple[] npoints) {     
      if(npoints == null)
         return null;      
      if(npoints.length <=k)
         return npoints;
      Tuple[] result = new Tuple[k];
   
      // Find Eucledian distances
      for(int i=0; i<npoints.length; i++) {
         npoints[i].distance = euclideanDistanceMethod(target, npoints[i]);
      }      
      quicksort(npoints, 0, npoints.length-1);      
      for(int i=0; i<k; i++) 
         result[i] = npoints[i];       
      return result;
   }
   
   public static void quicksort(Tuple[] npoints, int istart, int iend) {
      if(istart >= iend)
         return;      
      int ipivot = partition(npoints, istart, iend);
      quicksort(npoints, istart, ipivot-1);
      quicksort(npoints, ipivot+1, iend);
   }
   
   public static int partition(Tuple[] npoints, int istart, int iend) {
      int ipivot = istart;
      int p = istart;
      int i = istart + 1;
      
      while(i <= iend) {
         if(npoints[i].distance < npoints[ipivot].distance) {
            p++;
            swap(npoints, p, i);
         }
         i++;
      }
      swap(npoints, ipivot, p);
      return p;
   }

   public static void swap(Tuple[] npoints, int p, int i) {
      Tuple tmp = npoints[i];
      npoints[i] = npoints[p];
      npoints[p] = tmp;
   }
 
   public static void main(String[] args) {
      Tuple[] t = new Tuple[5];
      t[0] = new Tuple(90,8);
      t[1] = new Tuple(85,8);
      t[2] = new Tuple(4,7);
      t[3] = new Tuple(3,4);
      t[4] = new Tuple(8,10);
      
      Tuple target = new Tuple(1,1);
      
      System.out.println("Heap Result: ");
      Queue<Tuple> q = findKNearestNeighborsHeap(target, 3, t);
      while(!q.isEmpty()) {
         Tuple point = q.poll();
         System.out.println("(" + point.x + ", " + point.y + ")");
      }
      
      System.out.println("Quicksort Result: ");
      Tuple[] result = findNearestNeighborsQuicksort(target, 3, t);
      for(int i=0; i<result.length; i++)
         System.out.println("(" + result[i].x + ", " + result[i].y + ")");
   }
}
