public class deleteNodeinLinkedList {
    public static void main(String[] args) {
        /*
         * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list instead 
         * you will be given access to the node to be deleted directly.
         * 
         * It is garunteed that the nodes to be deleted is not a tail node in the list.
         */
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        
        printList(head);
    }   

    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //print linked list
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

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
