import java.util.*;

public class binaryTreePreOrderTraversal {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, return the preorder traversal of its mpdes values.
         *          A
         *         / \
         *        B   C
         * 
         * preorder is: root -> left -> right -> in this case : a -> b -> c
         * 
         * for this example:
         *                  0
         *              /       \
         *             1          2
         *            / \        / \
         *           3   4      5   6
         */
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(5), new TreeNode(6)));
        //System.out.println(root.val);

        System.out.println(preorderTraversal(root));
    }

    //iterative approach: iterative will always contain a stack
    public static List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();

        //base case if the tree is empty
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        //first push the root to the stack
        stack.push(root);

        while(!stack.isEmpty()){
            //create new TreeNode current that contains the value currently present at the top of the stack
            TreeNode current = stack.pop();
            
            //the list will record the current val before popping it aka removing it from the stack
            list.add(current.val);

             //likewise if the right is not null push the value of the right node to the stack
             if(current.right != null){
                stack.push(current.right);
            }

            //if the leftside of the tree is not null, push the leftndoe to the stack
            if(current.left != null){
                stack.push(current.left);
            }
        }

        return list;
    }

    //print treenode in preorder traversal
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

/*
 * recursive method:
 * 	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	public void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}
 */