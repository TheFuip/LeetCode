import java.util.*;
public class averageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, return the average values of the nodes on each level in the form of an array.
         * Answers within 10^-5 of the actual answer will be accepted.
         */
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        
        System.out.println(root.left == null ^ root.right == null);
        //printTree(root);
        //t(root);
        //System.out.println(solution(root));
        solution(root);
    }

    /*
     * solution:
     * Take two list one for storing the sum of the all node in the same level and one for counting the number of node on that level.
     */
    public static List<Double> solution(TreeNode root){
        ArrayList<Double> list = new ArrayList<>();
        
        if(root == null){
            return list;
        }
        
        //this will determine the current dfs level of the tree
        ArrayList<Integer> level = new ArrayList<>();

        dfs(root, 0, level, list);

        for(int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) / level.get(i));
        }
        System.out.println(list);
        return list;
    }

    public static void dfs(TreeNode root, int height, List<Integer> level, List<Double> list){
        if(root == null){
            return;
        }

        if(list.size() <= height){
            list.add((double) root.val);
            level.add(1);
        }else{
            list.set(height, list.get(height) + root.val);
            level.set(height, level.get(height) + 1);
        }

        dfs(root.left, height + 1, level, list);
        dfs(root.right, height + 1, level, list);
    }

    //print tree
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " -> ");

        printTree(root.left);
        printTree(root.right);
    }
}

/*
 *  public static void t(TreeNode root){
        if(root == null){
            return;
        }
        double sum = 0;
        double leftVal = root.left == null ? 0 : root.left.val;
        double rightVal = root.right == null ? 0 : root.right.val;
        sum += (rightVal + leftVal) / 2;

        System.out.println(sum);

        t(root.left);
        
 */