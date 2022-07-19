public class removeNthNodeFromEndOfList {
    public static void main(String[] args) {
        /*
         * Given the head of a linked list, remove the nth node from the end of the list and return its head.
         * 
         * EX: 1 - 2 - 3 - 4 - 5 | N = 2 | -> 1 - 2 - 3 - 5
         * basically start at the end (right side of vals), and subtract n from there so in this case it's 4
         */
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        list = removeNthFromEnd(list, 2);

        printList(list);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode slow = head;
        ListNode fast = head;

        //traverse the node n times | if n = 2, fast holds -> 3,4,5
        for(int i = 0; i < n; i++){
            if(fast.next == null){
                //if n is equal to however many nodes there are, just delete the headnode. this really only applies in the test where theere is 1 node and n = 1
                if(i == n - 1){
                    head = head.next;
                }
                return head;
            }
            //increment fast by 1
            fast = fast.next;
        }

        
        //now loop through the rest of the node vals inside of fast, while incrementing both fast and slow 
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        //remove the n'th node that corresponds with n from last
        if(slow.next != null){
            slow.next = slow.next.next;
        }

        return head;

    }

    //print out node
    public static void printList(ListNode head){
        if(head == null){
            return;
        }

        System.out.print(head.val + " -> ");

        printList(head.next);
    }
}

class ListNode { 
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}