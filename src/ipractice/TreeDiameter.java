package ipractice;

public class TreeDiameter {
   
   private class Node {
      int val;
      Node left;
      Node right;
      public Node(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
      }
   }
   
   public static int diameterTree(Node root) throws Exception {
      if(root == null)
         throw new Exception("Null Argument");
         
      return 1 + diameterTreeHelper(root.left, 0) + diameterTreeHelper(root.right, 0);
   }

   public static int diameterTreeHelper(Node root, int cntRecursive) {
      if(root == null)
         return 0;
      
      return 1 + Math.max(diameterTreeHelper(root.left, cntRecursive+1),  diameterTreeHelper(root.right, cntRecursive+1));
   }
   
   public Node createNode(int val) {
      return new Node(val);
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      TreeDiameter td = new TreeDiameter();
      Node root = td.createNode(1);
      root.left = td.createNode(2);
      root.left.left = td.createNode(3);
      root.left.right = td.createNode(4);
      root.left.right.left = td.createNode(5);
      
      root.right = td.createNode(6);
      root.right.left = td.createNode(7);
      root.right.right = td.createNode(8);
      root.right.right.right = td.createNode(9);
      
      int diam = 0;
      try {
         diam = diameterTree(root);
      } catch (Exception e) {
         e.printStackTrace();
      }
    
      System.out.println(diam);
   }
}
