import java.util.*;
public class binaryTreeInOrderTraversal {
    public static void main(String[] args) {
        /*
         * Given a binary Tree, return the inorder traversal of it's node values.
         * EX: left -> root -> right
         *      A
         *     / \ 
         *    B   C
         * = [B,A,C]
         */

    }  
    
    public static List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        //base case if the tree is empty
        if(root == null){
            return list;
        }

        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);

                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

    public static void printTreeInorder(TreeNode root){
        if(root != null){
            printTreeInorder(root.left);

            System.out.println(root.val);

            printTreeInorder(root.right);
        }

    }
}
class TreeNode{
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
