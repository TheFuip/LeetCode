import java.util.*;
public class binaryTreeRightSideView {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
         */
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));

        System.out.println(rightSideView(root));
    }
    //basically like a cool spin off of level order traversal xD
    public static List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        //offer the queue the root node to begun the while loop condition
        q.offer(root);

        while(!q.isEmpty()){
            //size will be used to reference the current size of the queue,
            int size = q.size();
            //run for loop until 'i' is equal to size
            for(int i = 0; i < size; i++){
                //create new treenode as q.poll() which removes the top/front treenode of the queue
                TreeNode current = q.poll();

                //basically just saying if i == 0 add current.val to the queue, we only do 0 because we only want to add 1 value at a time
                if(i == size - 1){
                    res.add(current.val);
                }

                //if the left branch of the queue is not null, offer current.left to the top of the queue
                if(current.left != null){
                    q.offer(current.left);
                }
                //if the right branch of the queue is not null, offer current.right to the top of the queue. :)
                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }

        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

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
