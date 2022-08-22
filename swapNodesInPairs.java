public class swapNodesInPairs {
    public static void main(String[] args) {
        /*
         * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list Node.
         * i.e, only nodes, themselves must be changed.
         * 
         * 1 - 2 -3 - 4 =
         * 2 - 1 - 4 - 3
         */

         ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

         printList(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head){
        ListNode temp = new ListNode(0);

        //from here temp will just include the original values of head
        temp.next = head;
        
        ListNode current = temp;

        while(current.next != null && current.next.next != null){
            ListNode pair1 = current.next;
            ListNode pair2 = current.next.next;

            pair1.next = pair2.next;
            
            current.next = pair2;
            current.next.next = pair1;

            //since we are traversing 2 at a time we do current = current.next.next
            current = current.next.next;
        }

        //return .next so we dont return the 0
        return temp.next;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
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
