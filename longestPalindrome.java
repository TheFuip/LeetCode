import java.util.*;

public class longestPalindrome {
    public static void main(String[] args) {
        /*
         * Given a string which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built
         * with those letter.
         */
        String s = "tattarrattat";
        //System.out.println(s.length());
        System.out.println(solution("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
    }
    public static int solution(String s){
        //if the string is only 1, just return 1, since that is the only possible distinct palindrome
        if(s.length() == 1){
            return 1;
        }
       
        HashSet<Character> set = new HashSet<>();

        //if the char appears multiple times in the set remove that char, otherwise just add it to the set if it only appears once
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }

        //if the size of the set is less than or equal to 1, return the length of s, otherwise if the set is greater than 1 return the length of the string - the size of the set + 1
        return set.size() <= 1 ? s.length() : s.length() - set.size() + 1;
    }
}

/*
 *  if(s.length() == 1){
            return 1;
        }
       
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            //max = Math.max(map.get(c), max);
            if(map.get(c) % 2 == 0){
                max+=2;
            }
        }

        System.out.println(map);

        if(max > 1 && map.size() == 1){
            return s.length();
        }

        if(max > 1 && !map.containsValue(1)){
            return s.length();
        }

        return max > 1 && map.containsValue(1) ? max + 1 : 1;
 */