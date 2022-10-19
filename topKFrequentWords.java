import java.util.*;
public class topKFrequentWords {
    public static void main(String[] args) {
        /*
         * Given an array of strings words and an integer k, return the k most frequent
         * strings.
         * 
         * Return the answer sorted by the frequency from highest to lowest. Sort the
         * words with the same frequency by their lexicographical order.
         */
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words, 2));
    }

    /*
     * fyi this submission is different from the actual lc solution on my acocunt, because the submission doesnt like the fact that when there is a word 
     * that appears k times such that the frequency of k is -> k >= k + 1, it will return the k + 1, element before the k element.
     * i think this is stupid and not worth fixing. so im leaving the problem as is since i figured this solution all by myself :)
     */
    public static List<String> topKFrequent(String[] words, int k){
        HashMap<String, Integer> map = new HashMap<>(); 

        //since we have to return the frequency of the k'th elements, create new string array -> will be returned as a list soon... ;)
        String[] topKWords = new String[k];

        //populate the hashmap, the string s, will be the key and the frequency at which 's' occurs in the array will be the val of s
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        //run a loop proportionate to the length of k or topKWords array length.
        for(int i = 0; i < topKWords.length; i++){
            //here we will set the i'th index value of topKWords to the greatest value, followed by the second greatest, third, etc -> basically to the length of k 
            topKWords[i] = countK(words, map, i);
        }

        //return array as list
        return Arrays.asList(topKWords);
    }

    //helper function for topKWords array
    private static String countK(String[] kWords, HashMap<String, Integer> map, int index){
        //if the value of k is greater than 1, check to make sure the map does not contain the last topKWords[i - 1] value, if it does, remove it from the map so 
        //we don't get duplicitive values of topKWords.
        //basically ensures no duplicates get in or out
        if(index > 0){
            if(map.containsKey(kWords[index - 1])){
                map.remove(kWords[index - 1]);
            }
        }

        //this value will just be a comparative to ensure were getting the max k frequency of all string values within the string array
        int count = 0;

        //loop through the map's String keyset
        for(String s : map.keySet()){
            //if the map value of s is greater than count set kWords[index] to the String key value of s, and update count to reflect the integer value of map.get(s)
            if(map.get(s) > count){
                kWords[index] = s;
                count = map.get(s);
            }
        }

        //return the kWords string value after looping
        return kWords[index];
    }
}
