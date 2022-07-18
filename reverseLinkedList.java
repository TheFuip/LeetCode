public class reverseLinkedList {
    public static void main(String[] args) {
        /*
         * Given the head of a singly linked list, reverse the list, and return the
         * reversed list.
         * 1,2,3,4 -> 4,3,2,1
         */
        ListNode ln = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ln = solution(ln);

        printListNode(ln);
    }

    public static ListNode solution(ListNode head) {
        // 2 pointer approach
        ListNode reverse = null;
        ListNode temp = null;

        while (head != null) {
            temp = head.next;

            head.next = reverse;

            reverse = head;

            head = temp;
        }

        return reverse;
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val + ", ");

        printListNode(head.next);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}