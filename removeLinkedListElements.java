public class removeLinkedListElements {
    public static void main(String[] args) {
        /*
         * Given the head of a linked list and an integer val, remove all the nodes of
         * the linked list that has Node.val == val
         * and return the new head.
         * 
         * EX: [1,2,6,3,4,5,6] val = 6 -> [1,2,3,4,5]
         * 
         * ex: head = [] val = 1 -> []
         * 
         * ex: head = [7,7,7,7] val = 7 -> []
         */
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        //ListNode head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(1, new ListNode(7)))));

        head = removeElements(head, 6);

        printList(head);
    }

    public static ListNode removeElements(ListNode head, int val) {
        //checks to see if the head value begins with the parameterised val, if it does remove that node from the list. i.e -> [7,7,1,7] pos = 7 -> will return [1,7] ending at the node that contains 1 since it is a different value than val
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode current = head;

        //loop until current is null or current.next is null
        while (current != null && current.next != null) {
            //if the current.next value equals val then set the current.next value (value that contains val) to the next node
            if (current.next.val == val) {
                current.next = current.next.next;
            } else { //otherwise just increment current normally 1 by 1
                current = current.next;
            }
        }

        return head;
    }

    // recursively print each element in the list
    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + " -> ");

        printList(head.next);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
 * recursive solution ::
 * 
 * if(head == null){
 * return head;
 * }
 * 
 * if(head.val == val){
 * return removeElements(head.next, val);
 * }
 * 
 * head.next = removeElements(head.next, val);
 * 
 * return head;
 */