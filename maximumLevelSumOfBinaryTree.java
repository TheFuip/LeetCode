import java.util.*;
public class maximumLevelSumOfBinaryTree {
    public static void main(String[] args) {
        /*
         * Given the root of a binary tree, the level of its root is 1, the level of it's children is 2, and so on.
         * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
         * 
         * Level 1 -            (1)         sum = 1
         *                    /     \
         * Level 2 -        (7)      (0)    sum = 7
         *                 /   \ 
         * Level 3 -     (7)   (-8)         sum = -1
         * 
         * therefore, return 2 -> since level 2 has the maximum sum
         */
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        TreeNode r1 = new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-312127))));
        TreeNode r2 = new TreeNode(-100, new TreeNode(-200, new TreeNode(-20), new TreeNode(-5)), new TreeNode(-300, new TreeNode(-10), null));
        System.out.println(maxLevelSum(root));
        //System.out.println(maxLevelSum(r1));

        //printLevelOrderTree(root);
        
    }
    
    public static int maxLevelSum(TreeNode root){
        //if the root is null just return 0
        if(root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;

        //add the root to the queue to activate the while loop
        q.offer(root);

        while(!q.isEmpty()){
            //for every level we will set sum to 0
            int sum = 0;
            
            //start i at the current size of the queue, loop until the first element in the queue
            for(int i = q.size(); i > 0; i--){
                //+= to the value at the front of the queue
                sum += q.peek().val;

                //if the front of the queue contains a left node, that is not null add it to the queue
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }//if the front of the queue contains a right node, that is not null add it to the front of the queue
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }

                //remove the first/front element in the queue
                q.poll();
            }

            //check if max is greater than the sum (since max is initially set to the lowest possible value this will always initially activate for the first time)
            //if it is greater set max to sum, and the maxLevel to the current level
            if(max < sum){
                max = sum;
                maxLevel = level;
            }
            
            //increment the level each time
            level++;
        }
        return maxLevel;
    }

    //print treeNode
    public static void printLevelOrderTree(TreeNode root){
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
            System.out.print(q.poll().val + ", ");
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