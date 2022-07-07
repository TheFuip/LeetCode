import java.util.HashMap;
import java.util.Map;

public class ransomNote {
    public static void main(String[] args) {
        /*
         * Given 2 strings, return true if 'ransomeNote' can be constructed by using letters from 'magazine' and false 
         * if otherwise
         * EX: rN = 'a' | mag = 'b' -> false
         * EX: rN = 'aa' | mag = 'aab' -> true
         * EX: rN = 'aa' | mag = 'ab' -> false
         * all entries consist of lowercase characters
         * Each letter in magazine CAN ONLY BE USED ONCE in ransomNote
         */
        System.out.println(canConstruct("baa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine){
        Map<Character, Integer> map = new HashMap<>();

        //populate hash map
        for(Character c : magazine.toCharArray()){
            //put c with the current count of equal chars set as the value + 1, or if c (char) does not exist put 0 with an additional count of 1
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //loop through each character of ransomNote
        for(Character c : ransomNote.toCharArray()){
            //if the map does not contain the currenct character in ransomNote, and the value of the current key is less than or equal to 0 we know ransomNote contains a new letter not found in magazine -> ergo return false
            if(!map.containsKey(c) || map.get(c) <= 0){
                return false;
            }

            //after each character iteration of ransomNote, reduce the value of the current key within the map
            map.put(c, map.get(c)-1);
        }

        //if the sequence survives the loop then it must be true
        return true;
    }
}
/*
 * "fihjjjjei"
"hjibagacbhadfaefdjaeaebgi"

  Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            map.put(magazine.charAt(i), i);
        }

        for(Character c : ransomNote.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) - map.get(c) - 1);

                if(map.get(c) < 1){
                    map.remove(c);
                }
            }else{
                return false;
            }
        }

        return true;
 */