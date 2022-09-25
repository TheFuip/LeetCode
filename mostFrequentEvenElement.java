import java.util.Arrays;
import java.util.HashMap;

public class mostFrequentEvenElement {
    public static void main(String[] args) {
        /*
         * Given an integer array nums, return the most frequent even element
         * if there is a tie, return the smallest one.
         * if there is no such element return -1;
         */
        int[] nums = {1,1,2};
        
        System.out.println(frequentEven(nums));
    }

    public static int frequentEven(int[]nums){
        //here we will sort the arrays from ascending order -> because if there is a tie on how many times the element appears we want to always return the smallest
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        //we will set ans to -1 and return it at the end of the method, so if there are no even numbers it returns -1 as intended.
        int ans = -1;
        //this will hold the max frequency of how many times an element appears
        int frequency = 0;

        for(int i = 0; i < nums.length; i++){
            //if the number is even add it to the hashmap | nums[i] as the key and the frequency of how many times it appears as the val
            if(nums[i] % 2 == 0){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

                //if the map val of nums[i] > the current value of frequency update frequency to the map val of nums[i], and set ans as nums[i]
                if(map.get(nums[i]) > frequency){
                    frequency = map.get(nums[i]);
                    ans = nums[i];
                }
            }
        }

        return ans;
    }
}
