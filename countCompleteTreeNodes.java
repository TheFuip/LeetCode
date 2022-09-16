import java.util.*;
public class countCompleteTreeNodes {
    public static void main(String[] args) {
        /*
         * Given the root of a complete binary tree, return the number of the nodes in
         * the tree.
         * 
         * According to Wikipedia, every level, except possibly the last, is completely
         * filled in a complete binary tree, and all nodes in the last level are as far
         * left as possible. It can have between 1 and 2h nodes inclusive at the last
         * level h.
         * 
         * Design an algorithm that runs in less than O(n) time complexity.
         * 
         * 
         */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(countNode(root));
        System.out.println(sol2(root));
    }
    //solution 1
    /*
     * straight of the bat if the tree is null return 0
     * create a new q and offer the root
     * while the q is not empty check if the left branch contains a node and add it to the q
     * repeat this process for the right branch
     * after the q determined whether the next left and right node are not null 
     * increment count
     * and remove the front of the q
     * repeat until there is no more elements left in the queue
     */
    public static int countNode(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        int count = 0;

        q.offer(root);

        while(!q.isEmpty()){
            if(q.peek().left != null){
                q.offer(q.peek().left);
            }
            if(q.peek().right != null){
                q.offer(q.peek().right);
            }
            count++;
            q.poll();
        }

        return count;
    }

    //solution 2 :: recursion ...?
    //seems to be accepted as an O(n) solution
    //basically real simple if the root is not null add 1 and traverse through the left and right nodes if the nodes are null return 0, indicating the end of the recursion
    public static int sol2(TreeNode root){
        return root != null ? 1 + sol2(root.left) + sol2(root.right) : 0;
    }

}
