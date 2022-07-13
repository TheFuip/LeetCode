import java.util.*;

public class containsDuplicateII {
    public static void main(String[] args) {
        /*
         * Given an integer array nums and an integer k, return true if there are two
         * distinct indices
         * i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k
         */
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicates(nums, 2));
    }

    public static boolean containsNearbyDuplicates(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //loop through the nums array
        for(int i = 0 ; i < nums.length; i++){
            //check if the map contains the current value of nums[i]
            //if it does check if the absolute value for the map val of nums[i] - i(current index value) is less than or equal to k return if it is
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i]) - i) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
/* wrong v1
 *   Map<Integer, Integer> map = new HashMap<>();

        // populate the hashmap with values from nums as the key, and how often these
        // values appear as the val in the map
        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return map.get(nums[k]) == 1 ? true : false; 

        wrong v2
            Map<Integer, Integer> map = new HashMap<>();

        // populate the hashmap with values from nums as the key, and how often these
        // values appear as the val in the map
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i], i);
        }

        return false; 

        v3 working
         Map<Integer, Integer> map = new HashMap<>();

        // populate the hashmap with values from nums as the key, and how often these
        // values appear as the val in the map
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i]) - i) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
 */