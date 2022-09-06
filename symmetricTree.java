import java.util.*;
public class symmetricTree {
    public static void main(String[] args) {
        /*
         * Given a binary tree determine if it is symmetrical (left branch is equal to the right branch)
         * 
         * 
         *                  (1)
         *               /       \
         *             (2)        (2)
         *            /   \      /   \
         *          (3)   (4)  (3)   (4)
         * returns true
         */
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        //printTree(root);
        System.out.println(isSymetrical(root));
    }
    public static boolean isSymetrical(TreeNode root){
        return symmetricHelper(root, root);
    }

    public static boolean symmetricHelper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return t1.val == t2.val && symmetricHelper(t1.left, t2.right) && symmetricHelper(t1.right, t2.left);// && symmetricHelper(t1.right, t2.left);
    }

    //print binary tree
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            if(q.peek().left != null){
                q.offer(q.peek().left);
            }
            if(q.peek().right != null){
                q.offer(q.peek().right);
            }
            System.out.print(q.peek().val + ", ");
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

