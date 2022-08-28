/**
 * longestSubstringWithoutRepeatingCharacters
 */
import java.util.*;
public class longestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        /*
         * Given a string 's' find the length of the longest substring without repeating characters.
         * 
         * EX: "abcabcbb" - "abc" -> 3
         * EX: "bbbbb" - "b" -> 1
         * EX: "pwwkew" - "kew" -> 3
         * EX: "dvdf" - "vdf" -> 3
         */
        System.out.println("e");
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s){
        //if there is only 1 length in the string return 1 as this can only be the distinct substring
        if(s.length() == 1){
            return 1;
        }

        int count = 0;
        int reset = 0;
        int max = 0;
        int start = 0;
        
        HashSet<Character> set = new HashSet<>();

        //while start is less than the length of s keep running this code iteration
        while(start < s.length()){
            //if the character is already contained in the set, clear the set, set count to 0; increment reset by 1 as, start will now begin 1 index spot higher than where it initially began
            if(set.contains(s.charAt(start))){
                set.clear();
                count = 0;
                reset++;
                start = reset;
            }
            //otherwise, the set must not contain the character, so add it to the set, increment count and set max to whatever the higher value currently is between 'max' and 'count', last but not least increment start to run another cycle until the looping condition is complete.
            set.add(s.charAt(start));
            count++;
            max = Math.max(count, max);
            start++;
        }

        return max;
    }

    private static boolean containsListNode(ListNode current, char val){
        if(current == null || current.val == val){
            return false;
        }

        current = current.next;

        return true;
    }

    private static class ListNode{
        char val;
        ListNode next;

        public ListNode(){}

        public ListNode(char val){
            this.val = val;
        }

        public ListNode(char val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}

/*
alternative solution better :: 

    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
 * 
 * 
 * //just ignore this stuff i dont even remember what i was planning to do with this code
 *  public static int lengthOfLongestSubstring(String s){
        if(s.length() == 1){
            return 1;
        }

        int count = 0;

        ListNode list = new ListNode(s.charAt(0));
        ListNode current = list;

        for(int i = 1; i < s.length(); i++){
            current.next = new ListNode(s.charAt(i));

            current = current.next;


        }

        while(list != null){
            System.out.print(list.val + " -> ");
            list = list.next;
        }
        System.out.println();
        return count;
    }

    private static boolean containsListNode(ListNode current, char val){
        if(current == null || current.val == val){
            return false;
        }

        current = current.next;

        return true;
    }
 */