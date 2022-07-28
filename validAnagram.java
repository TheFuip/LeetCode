import java.util.*;

public class validAnagram {
    public static void main(String[] args) {
        /*
         * Given 2 strings s, and t return true if it is an anagram of s and false
         * otherwise.
         * An anagram is a word or phrase formed by rearranging the letters of a
         * different word or phrase,
         * typically using all the original letters exactly once.
         * 
         * EX: -> s = "anagram", t = "nagaram" -> true
         * EX: -> s = "rat", t = "car" -> false
         */
        System.out.println(isAnagram("car", "ratatoca"));

    }

    public static boolean isAnagram(String s, String t) {
        // base case: if the length of s is shorter than t return false, because we know
        // we wont make an anagaram
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        /*
         * we will have each character inside of s increment based on how many times it appears,
         * while each character inside of t will decrement based on how many times it appears
         */
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        //for every character key inside of the map if the value is greater or less than 0 we know it is not a valid anagram
        //reason being is that it should be 0 indicating that the value has been evenly increased and decreased by the character 
        //s = "eee" -> adds 3 | t="eee" -> subtracts 3 making it 0 so valid anagram
        for(char c : map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }
        
        return true;
    }


}
