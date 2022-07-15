public class middleOfLinkedList {
    public static void main(String[] args) {
        /*
         * Given the head of a single linked list, return the middle node of the linked list.
         * If there are two middles nodes, return the second middle Node.
         * Ex: 1 - 2 - 3 - 4 - 5 -> [3,4,5] since (3) is the middle
         * Ex: 1 - 2 - 3 - 4 - 5 - 6 -> [4,5,6] since there are two middles nodes (3), and (4) so we return the second
         */
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

       //todo
       printListNode(middleNode(list));
    }   

    //2 pointer approach
    public static ListNode middleNode(ListNode head){
        ListNode current = head;
        ListNode middle = head;

        /*
         * A 2 pointer approach. 'current' will traverse the list at a regular pace, while 'middle' will traverse twice as fast.
         * By the time middle reaches the end of the list, current will have been at it's halfway point; thus resulting in current being in the middle of the list
         * from here we just return current.
         */
        while(middle != null && middle.next != null){
            current = current.next;
            middle = middle.next.next;
        }

        return current;
    }

    //print node
    public static void printListNode(ListNode ln){
        if(ln == null){
            return;
        }

        System.out.print(ln.val + " -> ");

        printListNode(ln.next);
    }
}

//class definition for single linked list
class ListNode {
    int val;
    ListNode next;

    //blank constructor
    ListNode(){}

    //constructor with just val as the parameter
    ListNode(int val){
        this.val = val;
    }

    //constructor with val, and next as parameters
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
