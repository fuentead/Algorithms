package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Write a function that will return the number of binary
 * trees that can be constructed, with 'n' nodes.
 * 
 * for, n=1 ==> 1 possible tree(just root)
 * for, n=2 ==> 2 possible trees (1.root->right, 2.root->left)
 * for, n=3 ==> 5 possible trees (1.root->right->right 2.root->right->left 
 *                3.root->left->left 4.root->left->right 5.root->left->right)
 *                
 * If you keep solving them, it will form a series called Catalan numbers. 
 * There is a formula for it, however this is solved by reviewing the underlying 
 * recursion. Recursion is based on tree-topology. Contents are not important.
 */
public class RecursionCountTrees {
   
   /*
    * Resolve count trees problem with recursive solution.
    * 
    * Start by having all the nodes on the left branch of 
    * the tree, then move one by one to the right side. 
    * Result is the combination of the left side and right
    * side results.
    */
   public static int recursionCountTrees(int nodeCount) {
      if(nodeCount == 0)
         return 1;
      
      int totalSum = 0;
      int leftSum = 0;
      int rightSum = 0;
      
      for(int i=1; i<=nodeCount; i++) {           
         leftSum = recursionCountTrees(i-1);
         rightSum = recursionCountTrees(nodeCount-i);           
         totalSum = totalSum + leftSum*rightSum;          
      } 
      return totalSum;           
   }

   public static int recursionCountTree(int n) {
      if(n == 1 || n == 0)
         return 1;
      else {
         int sum = 0;
         for(int i=1; i<=n; i++) {
            sum = sum + recursionCountTree(i-1) * recursionCountTree(n-i);
         }
         return sum;
      }
   }
   
   public static void main(String[] args) {
      int numTrees = recursionCountTrees(1);
      System.out.println("n=1, " +numTrees);
      
      int numTrees2 = recursionCountTrees(2);
      System.out.println("n=2, " +numTrees2);
      
      int numTrees3 = recursionCountTrees(3);
      System.out.println("n=3, " +numTrees3);
      
      int numTrees4 = recursionCountTrees(4);
      System.out.println("n=4, " +numTrees4);
   }
}
