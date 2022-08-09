public class sameTree {
    public static void main(String[] args) {
        /*
         * Given the roots of two binary trees, write a function to check if they are the same or not.
         * 2 binary trees are considered the same if they are structually identical and nodes have the same value.
         */
        //odd will be left | even will be right
        TreeNode p1 = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        TreeNode q1 = new TreeNode(0, new TreeNode(12), new TreeNode(2));

        System.out.println(isSameTree(p1, q1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q){
        //if both trees are null that indicates the tree has been traversed therefore the tree is symetrical, (at least from a structural standpoint)
        if(p == null && q == null){
            return true;
        }

        //unlike the and conditon if only one is false and the other is not we know the tree is not symetrical
        if(q == null || p == null){
            return false;
        }
        //if the any of the values from the current node are different than we also know the tree is not the same so also return false
        if(q.val != p.val){
            return false;
        }

        //keep traversing the tree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
