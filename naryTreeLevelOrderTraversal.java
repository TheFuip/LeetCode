import java.util.*;
public class naryTreeLevelOrderTraversal {
    /*
     * Given an n-ary tree, return the level order traversal of its nodes' values.
     * 
     * Nary-Tree input serialization is represented in their level order traversal,
     * each group of children is separated by the null value (See examples).
     *                                              (1)
     *                                         /     |     \
     *                                       (3)    (2)    (4)
     *                                      /   \
     *                                     (5)  (6)
     */
    public static void main(String[] args) {
        List<naryNode> r2 = new ArrayList<>();
        List<naryNode> r3 = new ArrayList<>();

        r3.add(new naryNode(5));
        r3.add(new naryNode(6));

        r2.add(new naryNode(3, r3));
        r2.add(new naryNode(2));
        r2.add(new naryNode(4));
        
        naryNode root = new naryNode(1, r2);
        
    }

    public static List<List<Integer>> levelOrder(naryNode root){
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>();

        Queue<naryNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int length = q.size();
            for(int i = 0; i < length; i++){
                subList.add(q.peek().val);

                //then loop through the list contained inside of 'naryTree' class
                for(naryNode n : q.peek().children){
                    q.offer(n);
                }
                q.poll();
            }
            list.add(subList);
            
        }
        System.out.println(list);
        return list;
    }

    //print naryNode
    public static void printnaryNode(naryNode root){
        if(root == null){
            return;
        }

        
    }

    private static class naryNode{
        int val;
        List<naryNode> children;

        public naryNode(){}

        public naryNode(int val){
            this.val = val;
        }

        public naryNode(int val, List<naryNode> children){
            this.val = val;
            this.children = children;
        }
    }
}
