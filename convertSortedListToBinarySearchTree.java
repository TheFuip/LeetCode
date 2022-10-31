import java.util.*;

public class convertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        //System.out.println(sortedListToBST(head));
        
        //printList(head);
        printTree(sortedListToBST(head));
    }

    //ans
    public static TreeNode sortedListToBST(ListNode head){
        //if the head is null, that means we cannot converto, so just return null
        if(head == null){
            return null;
        }

        return helper(head, null);
    }

    private static TreeNode helper(ListNode head, ListNode end){
        //here we will have 2 pointer fast which will increment by 2 nodes at a time, and slow which increments one node at a time
        ListNode slow = head;
        ListNode fast = head;

        //if the head = end return null, since the list is in sorted order that means only 1 node available
        if(head == end){
            return null;
        }
        
        //the fast and fast.next is not equal to the end increment fast by 2 nodes, and slow by 1 node, (fast always finish quicker than slow)
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }

        //since fast always finish quicker slow will always be at the 50%/halway point by the time fast finishes, so create new tree with this slow.val as the root
        TreeNode ans = new TreeNode(slow.val);

        //set ans.left as recursive function of helper, where head end/tail of the listnode is the slow val, basically from the first nodes until the middle
        ans.left = helper(head, slow);
        ans.right = helper(slow.next, end); //here ans.right will begin one after slow.next (+1 after the middle, and end until it finishes traversing the right side of the node)

        return ans;
    }

    //just prints out the list in recursive fashion
    public static void printList(ListNode head){
        if(head == null){
            return;
        }
        System.out.print(head.val + ", ");
        printList(head.next);
    }

    //print out BST recursively
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + ", ");

        printTree(root.left);
        printTree(root.right);
    }
}

//listnode class
class ListNode {
    int val;
    ListNode next;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

//tree class
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
