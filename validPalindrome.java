import java.util.*;
public class validPalindrome {
    public static void main(String[] args) {
        /*
         * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
         * removing all non-alphanumeirc characters, it reads the same forward and backward. 
         * Alphanumeric chracters include letters and numbers
         * Given a string return true if it's a palindrome or false otherwise.
         * EX: -> 'racecar' = true;
         * EX: -> 'abc' = false
         */
        System.out.println(isPalindrome("  car"));
    }

    public static boolean isPalindrome(String s){

        //just set s to only lowercase letters no special characters or whitespace
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        //loop through the length of the string
        for(int i = 0; i < s.length(); i++){
            //System.out.println(s.charAt(i) + " : " + i + " : " + s.charAt(s.length()-1-i));
            
            //compare the char value in the str with the value of the last value in the string - i (the index) | str length = 5 | char(0) = char(5) -> char(1) = char(4) -> etc 
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}

//two pointer approach (faster and better than my solution tbh)
/*
 *   int start = 0; 
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;

 */