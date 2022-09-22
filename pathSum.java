import java.util.*;
public class pathSum {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree and an integer targetSum, return true if the tree has a 'root-to-leaf' path such that
         * adding up all the values along the path equals targetSum
         * 
         * A leaf is a node with no children
         */
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        //printTree(root);
        System.out.println(hasPathSum(root, 29));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum){
        //first were checking if the root is null -> if it is that means there's no values in the tree so it impossible for the tree to have a targetSum return false
        //otherwise if we have exhausted both the left and the right branches and targetSum - root.val equals 0 that means we have a match therfore return true
        if(root == null){
            return false;
        }else if(root.left == null && root.right == null && targetSum - root.val == 0){
            return true;
        }
        //increment the left part of the tree while subtracting targetSum by each root.val, also traverse the right branch of the tree doing the same thing as the left
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //print tree
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + ", ");

        printTree(root.left);
        printTree(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
