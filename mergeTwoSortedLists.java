public class mergeTwoSortedLists {
    public static void main(String[] args) {
        /*
         * You are given the heads of 2 sorted linked lists.
         * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
         * EX: [1,2,4] | [1,3,4] -> [1,1,2,3,4,4]
         * EX: [] | [] -> []
         */
        ListNode head1 = new ListNode(1,new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        
        System.out.println("e");

        printListNode(mergeTwoLists(head1, head2));
    }   

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode temp = new ListNode(0);
        ListNode current = temp;

        while(list1 != null & list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null){
            current.next = list1;
            list1 = list1.next;
        }
        if(list2 != null){
            current.next = list2;
            list2 = list2.next;
        }

        return temp.next;
    }

    //print listnode
    public static void printListNode(ListNode head){
        if(head == null){
            return;
        }

        System.out.print(head.val + " -> ");

        printListNode(head.next);
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
 * recursive solution
 * 
 * if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
 */