
/**
 * mergeKSortedLists
 */
import java.util.*;

public class mergeKSortedLists {

    /*
     * You are given an array of k linked-lists, each linked-list is sorted in
     * ascending order.
     * Merge all the linked-lists into one sorted linked-list and return it.
     * 
     * [[1,4,5],[1,3,4],[2,6]]
     * []
     * [[]]
     * [[],[]]
     * [[],[1]]
     */
    public static void main(String[] args) {
        // listnode array full of 3 indices of listnodes

        ListNode lists[] = { new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        ListNode l1[] = { null, null, new ListNode(1) };
        ListNode l2[] = {};
        

        // printList(lists);
        printList(mergeKLists(lists));
    }

    public static void printList(ListNode[] lists) {
        for (ListNode ln : lists) {
            System.out.print(ln.val + ", ");
            ListNode ln2 = ln.next;
            while (ln2 != null) {
                System.out.print(ln2.val + ", ");
                ln2 = ln2.next;
            }
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        //if the list is null return null, since no elements can be merged
        if (lists.length == 0) {
            return null;
        }
        //if the list only contains 1 element just return that element since there are no future elements that can merged and sorted
        if (lists.length == 1) {
            return lists[0];
        }

        List<Integer> list = new LinkedList<>();

        //for each listnode inside of the list
        for (ListNode ln : lists) {
            //if the current node is not valid add the value to the list, and create a temp node to traverse the remaining node(s) attached to the initial head node while adding their values to the list
            if (ln != null) {
                list.add(ln.val);

                ListNode temp = ln.next;

                while (temp != null) {
                    list.add(temp.val);

                    temp = temp.next;
                }
            }
        }

        //if the list has no values added to it, that means the list is empty, therefore we can just return null
        if(list.isEmpty()){
            return null;
        }

        //sort the values inside of the list
        Collections.sort(list);

        //here we will set head to the first sorted value in the list
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        //since head already contains the first value in the list, we start at 1 instead of 0, and add current.next to the current corresponding iteration within the list
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));

            current = current.next;
        }

        return head;

    }

    // print out the list
    public static void printList(ListNode ln) {
        if (ln == null) {
            return;
        }

        System.out.print(ln.val + " -> ");

        printList(ln.next);
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