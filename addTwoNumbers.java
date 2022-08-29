import java.util.*;
public class addTwoNumbers {
    public static void main(String[] args) {
        /*
         * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
         * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
         * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
         * EX: L1 = [2,4,3] | L2 = [5,6,4] -> 342 + 565 = 807 -> return [8,0,7]
         */
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        //ListNode node = addTwo(l1, l2);

        //printListNode(reverse);
        printListNode(addTwo(l1, l2));
    }

    public static ListNode addTwo(ListNode l1, ListNode l2){
        ListNode temp = new ListNode(0);
        ListNode current = temp;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return temp.next;
    }

    private static ListNode reverseList(ListNode head){
        ListNode reverse = null;
        ListNode temp = null;

        while(head != null){
            temp = head.next;
            head.next = reverse;

            reverse = head;
            head = temp;
        }
        return reverse;
    }

    //print out node
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

    ListNode(){}

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

/*
 *    String num1 = "";
        String num2 = "";

        ListNode sum = null;

        while(l1 != null && l2 != null){
            num1 += String.valueOf(l1.val) + "";
            num2 += String.valueOf(l2.val) + "";

            l1 = l1.next;
            l2 = l2.next;
        }

        int total = Integer.parseInt(num1) + Integer.parseInt(num2);

        System.out.println(total);
        
        return l1;
 */