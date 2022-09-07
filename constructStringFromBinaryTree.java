import java.util.*;
public class constructStringFromBinaryTree {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree 
         * with the preorder traversal way, and return it.
         * 
         * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between 
         * the string and original binary tree
         * 
         *                      (1)
         *                   /       \
         *                 (2)       (3)
         *                /
         *              (4)
         *  = 1(2(4)(3)
         */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode root){
        if(root == null){
            return "";
        }

        if(root.left == null && root.right == null){
            return root.val + "";
        }

        if(root.right == null){
            return root.val +"(" + tree2str(root.left) + ")";
        }

        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
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