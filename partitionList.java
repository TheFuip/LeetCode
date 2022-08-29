public class partitionList {
    public static void main(String[] args) {
        /*
         * Given the head of a linked list and a value x, partition it such that all
         * nodes less than x come before nodes greater than or equal to x.
         * 
         * You should preserve the original relative order of the nodes in each of the
         * two partitions.
         * 
         * Input: head = [1,4,3,2,5,2], x = 3
         * Output: [1,2,2,4,3,5]
         * 
         * Input: head = [2,1], x = 2
         * Output: [1,2]
         */
        ListNode head = new ListNode(1,
                new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));

        printListNode(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        //here before: will represent all the node vals lower than x
        //after will represent all the node vals greater or equal to x
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while(head != null){
            //if the current val of head is less than x -> set before.next to the current listnode of head
            if(head.val < x){
                before.next = head;

                //traverse through the next node
                before = before.next;
            }else{ //otherwise x is greater than head.val -> so set after to the listnode of head
                after.next = head;

                //traverse through the node by 1
                after = after.next;
            }

            head = head.next;
        }

        //the last node of after would be the ending node of the list so set it null
        after.next = null;

        //here we will apply the greater nodes to the last part of the before list(before:: all node values less than x)
        before.next = afterHead.next;

        //return beforeHead.next, as beforeHead would contain a 0
        return beforeHead.next;
    }

    // print listnode
    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + " -> ");

        printListNode(head.next);
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