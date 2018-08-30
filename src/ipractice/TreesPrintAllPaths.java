package ipractice;
/**
 * @author Adriana Fuentes
 *
 */
public class TreesPrintAllPaths {

   static class Tuple {
      Node left;
      Node right;
      public Tuple(Node left, Node right) {
         this.left = left;
         this.right = right;
      }
   }
   
   static class Node {
      int value;
      Node left;
      Node right;
      
      public Node(int value) {
         this.value = value;
         this.left = null;
         this.right = null;
      }
   }
   
   public static Node addRoot(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Tuple addChildren(Node n, int dataLeft, int dataRight) {
      n.left = new Node(dataLeft);
      n.right = new Node(dataRight);      
      return new Tuple(n.left, n.right);
   }
   
   public static void printAllPaths(Node n) {
      if (n == null)
         return;
      
      int[] data = new int[100];
      printAllPathsHelper(n, data, 0);
   }
   
   private static void printArray(int[] data, int len) {
      int i=0;
      while(data[i] != 0 && i<len) {
         System.out.print(data[i] + " ");
         i++;
      }
      System.out.println();
   }
   
   private static void printAllPathsHelper(Node n, int[] data, int index) {
      if(n == null || index >= data.length) {
         return;
      }
      data[index] = n.value;
      if(n.left == null && n.right == null)
         printArray(data, index+1);
      else {
         printAllPathsHelper(n.left, data, index+1);
         printAllPathsHelper(n.right, data, index+1);
      }
   }
   
   private static void printAllPaths2(Node n) {
      if(n == null)
         return;
      
      StringBuilder sb = new StringBuilder();
      printAllPathsHelper2(n, sb);
   }
   
   private static void printAllPathsHelper2(Node n, StringBuilder sb) {
      if(n == null)
         return;
      
      sb.append(n.value + " ");
      if(n.right == null && n.left == null) {
         System.out.println(sb.toString());
         return;
      }
      
      printAllPathsHelper2(n.left, sb);
      sb.delete(sb.length()-2, sb.length());
      printAllPathsHelper2(n.right, sb);
      sb.delete(sb.length()-2, sb.length());
   }
   
   public static void main(String[] args) {
      Node root = addRoot(5);
      Tuple t = addChildren(root, 3, 8);
      addChildren(t.left, 1, 4);
      addChildren(t.right, 6, 10);
      
      printAllPaths2(root);
   }
}
