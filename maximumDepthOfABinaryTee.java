public class maximumDepthOfABinaryTee {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, return its maximum depth.
         * 
         * A binary tree's maximum depth is the number of nodes along the longest path
         * from the root node down to the farthest leaf node.
         */
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(5)),
                new TreeNode(2, new TreeNode(4), new TreeNode(6)));
        TreeNode r1 = new TreeNode(1, null, new TreeNode(2));

        //printTree(root);
        System.out.println(maxDepth(r1));
    }
    public static int maxDepth(TreeNode root){
        //if the root is null return 0
        if(root == null){
            return 0;
        }
        
        //here we return 1 for every right and left node per level, it's as if we simultaneously check for to see if the tree contains a left and right node at the same time
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // print tree
    public static void printTree(TreeNode root) {
        if (root == null) {
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

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
