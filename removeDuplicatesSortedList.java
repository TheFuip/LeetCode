public class removeDuplicatesSortedList {
    public static void main(String[] args) {
        /*
         * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
         */

         //node format -> 1 -> 1 -> 2 -> 3 -> 3
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        node = deleteDuplicates(node);

        //prints the node recursively
       printNodeRecursive(node);
    }

    //working
    public static ListNode deleteDuplicates(ListNode head){
        //create a new listnode which will be used to compare node values with the head parameter listnode
        ListNode current = head;
        
        //while the current node and the next node is not null check this conditional while loop sequence | we add current != null && current.next != null, in order to avoid the program traversing to a null node value
        while(current != null && current.next != null){
            //check if the current val is equal to the next current val within head ListNode, if it is set current's next node val to +1 next node val or current next, next node. In the event the Nodes are -> 1, 1, 1 the loop will end and just return 1
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next; //otherwise just move onto the next node reference
            }
        }

        return head;
    }

    //method that just prints the node recursively
    public static void printNodeRecursive(ListNode head){
        if(head == null){
            return;
        }

        System.out.print(head.val + " -> ");

        printNodeRecursive(head.next);
    }
}

class ListNode{
    //data parameters within the listnode class
    int val;
    ListNode next;

    //blank constructor
    ListNode(){}

    //constructor with only val passed as parameter
    ListNode(int val){
        this.val = val;
    }

    //constructor with both val and next passed as parameter
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }


}
