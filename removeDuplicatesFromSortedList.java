public class removeDuplicatesFromSortedList {
    public static void main(String[] args) {
        /*
         * Given the head of a sorted linked list, delete all nodes that have duplicate
         * numbers, leaving only distinct numbers from the original list. Return the
         * linked list sorted as well.
         */
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        printNodes(deleteDuplicates(head1));
        //printNodes(test(head1));
    }

   

    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode sorted = new ListNode(0, head);
        ListNode previous = sorted;

        while(head != null){
            //if the next head value is not null and the current head value equals the next head val, skipp all duplicates
            if(head.next != null && head.val == head.next.val){

                //move until the end of duplicates sublist
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                //skip all duplicates
                previous.next = head.next;
            }else{
                //otherwise increment previous
                previous = previous.next;
            }
            //keep traversing through the head node
            head = head.next;
        }
        //we do .next otherwise we would return the additional 0 appended to the front of sorted
        return sorted.next;
    }

    public static void printNodes(ListNode head){
        while(head != null){
            System.out.print(head.val + ", ");
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

/*
 *  ListNode current = head.next;
        ListNode temp = new ListNode(head.val);
        ListNode sorted = temp;
        int tempVal = head.val;
        
        while(current != null){
            if(tempVal != current.val){
                temp.next = new ListNode(current.val);
                tempVal = current.val;
                temp = temp.next;
            }

            current = current.next;
        }

        return sorted;
 */