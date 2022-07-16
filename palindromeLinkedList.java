import java.util.*;

public class palindromeLinkedList {
    public static void main(String[] args) {
        /*
         * 
         */
        ListNode node = new ListNode(11, new ListNode(2, new ListNode(2, new ListNode(1))));

        System.out.println(isPalindrome(node));
    }

    /*
     * 2 - pointer approach front list, and back list
     */
    public static boolean isPalindrome(ListNode head){
        //first we must determine the length of the node. to do this we must iterate through the listnode of head, but we will have to perform 2 traversals
        //and since 2 traversals are not possible wiht one node, we must create a copy of listnode that contaisn the data of head.
        ListNode reverse = head;

        //this will prove effective later as we need an iterator 
        int count = 0;

        //front will store all the node values from the left (front) | back will store all the node values from the right(back)
        ArrayList<Integer> back = new ArrayList<>();
        ArrayList<Integer> front = new ArrayList<>();

        //traverse through reverse listnode first, and add each node value to front list
        while(reverse != null){
            front.add(reverse.val);

            reverse = reverse.next;
        }

        //after traversing we will need to populate 'back' list. to do this we start i at the length of front's list size, and add each 'i' (iterative value) into to 'back' list
        for(int i = front.size()-1; i > -1; i--){
            back.add(front.get(i));
        }

        //now we will traverse through head listnode. since back contains all list values sorted from the back (right to left), if at any point the value of head does not equal the value of count (iterator) we know it's not palindrome so return false
        while(head != null){
            if(head.val != back.get(count)){
                return false;
            }

            //count is the iterative value that will come in handy. this is used to fetch index position values from back array list
            count++;

            head = head.next;
        }

        return true;
    }

    //print node vals
    public static void printListNode(ListNode head){
        if(head == null){
            return;
        }

        System.out.print(head.val + " -> ");

        printListNode(head.next);
    }
}

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
