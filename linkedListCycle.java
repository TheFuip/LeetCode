public class linkedListCycle {
    public static void main(String[] args) {
        /*
         * Given the head of a sorted linked list, delete all nodes that have duplicate
         * numbers, leaving only distinct numbers from the original list. Return the
         * linked list sorted as well.
         * 
         * 
         */
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
