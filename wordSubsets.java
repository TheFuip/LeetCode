import java.util.*;
public class wordSubsets {
    public static void main(String[] args) {
        /*
         * You are given 2 string arrays.
         * 
         * A string b is a subset of string a if every letter in b occures in a including multiplicity.
         *  . For example 'wrr' is a subset of 'warrior' but is not a subset of world.
         * A string a from words1 is universal if for every string b in words2, b is a subset of a.
         * 
         * Return an array of all the inversal strings in words1. You may return the answer in any order.
         */
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e", "o"};

        System.out.println(solution(words1, words2));
    }

    public static List<String> solution(String[] words1, String[] words2){
        int[] count = new int[26], tmp;
        int i;
        for (String b : words2) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : words1) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < count[i])
                    break;
            if (i == 26) res.add(a);
        }
        return res;
    }

    public static int[] counter(String word){
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
    //helper function with hashmap for each string value. they key will be the string and the val will be boolean true or false, whether it fits the criteria of words2
}

/*
      //part1
     HashMap<String, Boolean> map = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();

        for(String s : words1){
            map.put(s, isSubset(s, words2));

            if(map.get(s) == true){
                list.add(s);
            }
        }

        //if the map contains no entries just return a blank empty otherwise return the normal list
        //return map.size() > 0 ? list : Collections.emptyList();

        return list;

    //part 2
    int count = 0;

       // System.out.println(s);

        for(int i = 0; count != words2.length; i++){
            if(i == s.length()){
                return false;
            }

            //System.out.println("i = "+i + ", char = " +s.charAt(i) + " : count ="+count +", " + words2[count]);

            if(s.charAt(i) == words2[count].charAt(0)){
                count++;
            }
        }

        return true;
 */
