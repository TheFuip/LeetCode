import java.util.*;

public class convertSortedArraytoBinaryTree {
    public static void main(String[] args) {
        /*
         * Given an integer array nums where the elements are sorted in ascending order,
         * convert it to a height-balanced binary search tree.
         * 
         * A height-balanced binary tree is a binary tree in which the depth of the two
         * subtrees of every node never differs by more than one.
         * 
         * 
         */
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int[] nums = {-10,-3,1,5};
       // sortedArrayToBST(nums);
        //printTree(root);
        printTree(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums){
        return nums.length == 1 ? new TreeNode(nums[0]) : helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }

        int middle = (start + end) / 2;

        TreeNode current = new TreeNode(nums[middle]);

        current.left = helper(nums, start, middle - 1);
        current.right = helper(nums, middle + 1, end);

        return current;
    }

    //print tree :: iterative edition :P
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            System.out.print(q.peek().val + ", ");      
            if(q.peek().left != null){
                q.offer(q.peek().left);
            }
            if(q.peek().right != null){
                q.offer(q.peek().right);
            }
            q.poll();
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