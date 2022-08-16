import java.util.*;
public class firstUniqueCharacterInAString {
    public static void main(String[] args) {
        /*
         * Given a string, find the first non-repeating character in it and return it's index.
         * If it does not exist, return -1.
         */
        System.out.println(firstUniqChar("golloge"));
    }
    public static int firstUniqChar(String s){
        //base case: if there is only 1 char this can only be the first non-repating character therefore just return the 1st index
        if(s.length() < 2){
            return s.length() - 1;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        //populate the hashmap, with the character being the key and the value being the frequency of how many times the key appears throughout the string
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //loop through the string, if the string contains the value 1, return the index of s.charAt(i)
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}
