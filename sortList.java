import java.util.*;
public class sortList {
    public static void main(String[] args) {
        /*
         * Given the head of a linked list, return the list after sorting it in ascending order.
         * 
         * [4,2,1,3] -> [1,2,3,4]
         */
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        printListNode(solution(head));

        //printListNode(head);
    }

    public static ListNode solution(ListNode head){
        //if the list is empty just return null
        if(head == null){
            return null;
        }
        
        //create a new array list and fill the list with the int values contained in the node by calling 'fillList(ListNode '') method'
        List<Integer> list = new ArrayList<>(fillList(head));

        //sort the list in ascending order
        Collections.sort(list);

        //set head to a new listnode with only 1 value, aka the smallest value in the list beginning at index 0 (since sorted...)
        head = new ListNode(list.get(0));
        ListNode current = head; //make a new listnode and set it to head node

        //since the head node already contains the first value inside the list, start the list at 1 
        for(int i = 1; i < list.size(); i++){
            //set the value after current to the index value contained in the arraylist
            current.next = new ListNode(list.get(i));

            //increment current
            current = current.next;
        }
        
        return head;
    }

    //just fills the list with all the node values
    private static List<Integer> fillList(ListNode head){
        List<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);

            head = head.next;
        }

        return list;
    }

    //print list
    public static void printListNode(ListNode head){
        while(head != null){
            System.out.print(head.val +", ");
            head = head.next;
        }
    }
}
class ListNode{
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
