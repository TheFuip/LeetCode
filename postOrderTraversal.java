import java.util.*;

public class postOrderTraversal {
    /*
        B
      /   \
     A     C

     PosOrder is, left nodes, then right nodes then root.
     A -> C -> B
                      |
     for this example v
                        |
                        0
                     /     \
                    2        3
                   / \      / \
                  4   6    5   7
    */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3, new TreeNode(5), new TreeNode(7)));

        System.out.println(postOrderSolution(root));
       
    }    

    //return a list in post order solution
    //recursive approach
    public static List<Integer> postOrderSolution(TreeNode root){
        LinkedList<Integer> list = new LinkedList<Integer>();

        //basically inputs the data contained in postOrderHelper method into the linkedlist
        postOrderHelper(root, list);

        return list;
    }

    public static void postOrderHelper(TreeNode root, List<Integer> list){
        //end the recursions if the root reaches a point of null
        if(root == null){
            return;
        }

        //first recurse through the left side of the tree
        postOrderHelper(root.left, list);

        //once the leftside has been traversed recurse through the rightside of the tree
        postOrderHelper(root.right, list);

        //add each entry to the list
        list.add(root.val);
    }

    //print in post order
    public static void printPostOrder(TreeNode root){
        if(root == null){
            return;
        }

        printPostOrder(root.left);

        printPostOrder(root.right);

        System.out.println(root.val);
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
