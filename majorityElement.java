import java.util.*;

public class majorityElement {
    public static void main(String[] args) {
        /*
         * Given an array, return the majority element.
         * The majority element, is the element that appears more than n / 2 times.
         * You may assume the majority element always exists in the array.
         */
        int[] nums = {3,2,3,5,5,1,5};
        System.out.println(solution(nums));
    }    
    public static int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        //populate the hashmap, with the key being 'n' (the number(s)) inside of 'nums' and the value being how many times 'n' appears within 'nums'
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //set the count to the value of the first array in nums
        int count = nums[0];

        //since count is set to the first array value in nums, we start the for loop at 1
        for (int i = 1; i < nums.length; i++) {
            //if the current index map value is greater than the current map value of 'count' update count to the current nums[i] value
            if (map.get(nums[i]) > map.get(count)) {
                count = nums[i];
            }
        }

        return count;
    }
}
/* */