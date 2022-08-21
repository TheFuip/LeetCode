import java.util.*;
public class binaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, return the level order traversal of it's nodes.
         * I.E, from left to right, level by level
         * 
         *              0
         *            /   \
         *           1     2
         *         /  \   / \
         *        3    5 4   6
         * = [[0], [1,2], [3,5,4,6]]
         * solution = dfs depth first search
         */
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(5)), new TreeNode(2, new TreeNode(4), new TreeNode(6)));
        //printLevelOrder(root, treeHeight(root));
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        //starting from the first level - aka the root of the tree
        levelOrderHelper(ans, root, 0);

        return ans;
    }

    public static void levelOrderHelper(List<List<Integer>> list, TreeNode root, int level){
        if(root == null){
            return;
        }

        //create a new blank integer list
        List<Integer> current;

        //check if level is greater or equal to the list size -> set the list type to current as an array list, and add the current TreeNode val into the integer list (current), then use the paramter list (list<list<integer>> to add current (list<integer))
        if(level >= list.size()){
            current = new ArrayList<>();
            current.add(root.val);
            list.add(current);
        }else{ //otherwise the level is less than the size of the list parameter -> set current to the list value of the n'th (level value contained in list<list<integer>>)
            current = list.get(level);
            current.add(root.val); //then add the TreeNode value into current
        }

        //recurise to the left branch of the tree onto the next level passed the root, than follow this same process for the right branch of the tree
        levelOrderHelper(list, root.left, level + 1);
        levelOrderHelper(list, root.right, level + 1);
    }

    //print out treenode in level order
    public static void printLevelOrder(TreeNode root, int height){
        if(root == null){
            return;
        }

        if(height == 1){
            System.out.print(root.val + ", ");
        }else if(height > 1){
            printLevelOrder(root.left, height - 1);
            printLevelOrder(root.right, height - 1);
        }
    }

    public static int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        if(leftHeight > rightHeight){
            return leftHeight + 1;
        }else{
            return rightHeight + 1;
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
