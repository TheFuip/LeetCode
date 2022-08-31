public class lowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        /*
         * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
         * of two given nodes in the BST.
         * 
         * According to the definition of LCA on Wikipedia: “The lowest common ancestor
         * is defined between two nodes p and q as the lowest node in T that has both p
         * and q as descendants (where we allow a node to be a descendant of itself).”
         * 
         *                  6
         *              /        \
         *             2            8
         *          /    \        /   \
         *         0       4     7      9
         *              /    \
         *             3      5
         */
        TreeNode head = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        
       // TreeNode ans = solution(head, new TreeNode(2), new TreeNode(8));

        //printTree(ans);
    }

    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q){
        //if the value of p, is less than the value of the current root node, and the value of q, is less than the value of the current root node
        //traverse the left branch of the tree
        if(p.val < root.val && q.val < root.val){
            return solution(root.left, p, q);
        }

        //otherwise if the value of p and q is greater than the value of the current root node, keep traversing the right branch of the tree
        if(p.val > root.val && q.val > root.val){
            return solution(root.right, p, q);
        }

        return root;
    }

    //print tree | beggining at root then left to right
    public static void printTree(TreeNode head){
        if(head == null){
            return;
        }

        System.out.print(head.val + ", ");

        printTree(head.left);
        printTree(head.right);
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