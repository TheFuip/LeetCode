import java.util.*;

public class wordPattern {
    public static void main(String[] args) {
        /*
         * Given a pattern and a string s, find if s follows the same pattern.
         * 
         * Here follow means a full match, such that there is a bijection between a
         * letter in pattern and a non-empty word in s.
         * 
         * Input: pattern = "abba", s = "dog cat cat dog"
         * Output: true
         * 
         * Input: pattern = "aaaa", s = "dog cat cat dog"
         * Output: false
         */
        System.out.println("e");
        System.out.println(solution("abba", "dog dog dog dog"));
        //testfor: "ab" -> "dog dog" return false | "aba" -> "dog cat cat" return true
    }

    public static boolean solution(String pattern, String s){
        //first seperate each word inside of s by using an array, and splitting/ending the current iteration of the array for each word in the array.
        String[] sTemp = s.split(" ");

        //immediately we can come to the conclusion that if the number of indexes in the array is less than or greater than the length of pattern - instantly return false
        if(sTemp.length != pattern.length()){
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();

        //first we will check if the key (pattern char) is not present in the map, in addition to the current value of sTemp[i] not being present. If both these conditions are true add the pattern char(i) as the key and sTemp[i] as the value into the map
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(sTemp[i])){
                map.put(pattern.charAt(i), sTemp[i]);
            }else if(!sTemp[i].equals(map.get(pattern.charAt(i))) ){ //otherwise if the key is already present in the map and contains the value, check if the current value of sTemp[i] does not match the current key value of patter.charAt(i) if this condition is true return false
                return false;
            }
        }
        
        return true;
    }
}
 /*
  *         //first seperate each word inside of s by using an array, and splitting/ending the current iteration of the array for each word in the array.
        String[] temp = s.split(" ");

        //immediately we can come to the conclusion that if the number of indexes in the array is less than or greater than the length of pattern - instantly return false
        if(temp.length < pattern.length() || temp.length > pattern.length()){
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            //if the current chat inside of pattern is not added to the map -> add it and set temp[i] as the value
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), temp[i]);
            }else if(!temp[i].equals(map.get(pattern.charAt(i)))){ //otherwise if the map already contains the current char(i) value of pattern check if temp[i] is equal to the current char value of pattern -> if it does than it is valid, otherwise if temp[i] is a different value than it is invalid
                return false;
            }
        }

        return true;
  */