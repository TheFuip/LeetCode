import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        /*
         * Given an array of strings strs, group the anagrams together. You can return
         * the answer in any order.
         * 
         * An Anagram is a word or phrase formed by rearranging the letters of a
         * different word or phrase, typically using all the original letters exactly
         * once.
         * 
         * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */
         String[] strs = {"eat","tea","tan","ate","nat","bat"};

         System.out.println(solution(strs));
    }

    public static List<List<String>> solution(String[] strs) {
        if(strs.length == 1){
            return new ArrayList<>();
        }
        
        HashMap<String, List<String>> map = new HashMap<>();

        List<List<String>> list = new ArrayList<>();
        
        //loop through the string array
        for(String s : strs){
            //set s to a char array
            char[] c = s.toCharArray();

            //sort the char array
            Arrays.sort(c);

            //key will be the string equivalent of the current char value
            String key = String.valueOf(c);

            //if the map does not contain the key add the current char value as the key for the map along with a new array list
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());

    }

    public static List<String> anagramHelper(String[] strs, String str, int index){
        List<String> list = new ArrayList<>();

        char[] c = new char[str.length()];

        //convert the str parameter into a char array
        for(int i = 0; i < c.length; i++){
            c[i] = str.charAt(i);
        }
    
        boolean possibleAnagram = false;
        
        for(int i = index + 1, charIndex = 0; i < strs.length; i++){
            if(strs[i].contains(String.valueOf(c[charIndex]))){
                charIndex++;
                possibleAnagram = true;

                while(possibleAnagram){
                    if(charIndex == str.length() - 1){
                        list.add(strs[i]);
                    }

                    if(strs[i].contains(String.valueOf(c[charIndex]))){
                        charIndex++;
                    }else{
                        possibleAnagram = false;
                    }
                }
            }
        }

        //remove all empty values from the list
        list.replaceAll(s -> "");

        return list;
    }
}

/*
 * //int count = str.length();

        for(int i = 0, count = str.length()-1; i < strs.length; i++){
            boolean check = true;
            while(check){
                if(count <= 0){
                    list.add(strs[i]);
                }

                char c = strs[i].charAt(count);
                
                if(!str.contains(String.valueOf(c))){
                    check = false;
                }else{
                    count--;
                }
            }
            list.add(strs[i]);
        }

        //remove all empty values from the list
        list.replaceAll(s -> "");
 */