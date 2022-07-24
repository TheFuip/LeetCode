import java.util.Arrays;
import java.util.HashMap;

public class thirdMaximumNumber {
    public static void main(String[] args) {
        /*
         * Given an integer, return the third distinct maximum in this array.
         * if the third max does not exist, return the maximum number.
         * [3,2,1] = 1 -> since 1 is the THIRD largest
         * [1,2] = 2 -> since the array does not have 3 numbers we return the largest
         * [3,2,2,1] -> = 1 -> since 1 is the Third Largest
         * [1,2,3,2] = 1 -> since 1 is the third largest
         */
        int[] nums = {2,2,3,1}; // sorted -> 17,19,20,22,23,27

        System.out.println(thirdMax(nums));
    }

   
    public static int thirdMax(int[] nums) {
        // we will use a map, where the key will be count to keep track of iterations,
        // and the val will be nums[i]
        HashMap<Integer, Integer> map = new HashMap<>();

        if (nums.length < 3) {
            // will contain the answer if there are 2 or less entries inside of nums. by
            // default set this to the minimum values possible
            int ans = Integer.MIN_VALUE;

            // just set ans to the highest value in the array
            for (int n : nums) {
                ans = Math.max(n, ans);
            }
            return ans;
        } else {
            // used to keep track of numbers iterations
            int count = 0;

            // sort the array from small to great
            Arrays.sort(nums);

            for (int i = nums.length - 1; i > -1; i--) {
                // if the map does not contain nums[i] add it to the map as the val, and the key
                // as the current value of count
                if (!map.containsValue(nums[i])) {
                    map.put(count, nums[i]);
                    // update count
                    count++;
                }

                // if the map contains the key '2' denoting the third largest value return the
                // value which nums[i]
                if (map.containsKey(2)) {
                    return map.get(2);
                }
            }
        }

        //will just return the greatest value stored inside the map, which is 0 after sorting. This return statement will only trigger if the array contains 2 or less unique numbers
        return map.get(0);
    }
}
