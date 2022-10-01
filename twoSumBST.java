import java.util.*;
public class twoSumBST {
    public static void main(String[] args) {
        /*
         * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
         */
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(findTarget(root, 3));
    }

    public static boolean findTarget(TreeNode root, int k){
        //if the tree is empty just return false
        if(root == null){
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        //offer the root to the queue
        q.offer(root);

        //while the q contains treenodes...
        while(!q.isEmpty()){
            //if the top of queue's treenode contains a left node, add it to the queue
            if(q.peek().left != null){
                q.offer(q.peek().left);
            }
            //if the top of the queue's treenode contains a right node, add it to the queue
            if(q.peek().right != null){
                q.offer(q.peek().right);
            }

            //if the set is greater than 0, as it required a minimum of 2 elements present hence ('TwoSum') and the set contains the value present at the top of the queue return true, as a two sum can add to the target
            if(set.size() > 0 && set.contains(q.peek().val)){
                return true;
            }else{ //otherwise add the target value subtracted by the value at the top of the queue to the set. (we use q.poll() as this retreives the front of the queue while simultaneously remove it from the queue as well)
                set.add(k - q.poll().val);
            }
        }

        return false;
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
