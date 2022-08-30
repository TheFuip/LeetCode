import java.util.Arrays;

public class arrayPartition {
    public static void main(String[] args) {
        /*
         * Given an integer array nums of 2n integers, group these integers into n pairs
         * (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i
         * is maximized. Return the maximized sum.
         * 
         * Input: nums = [1,4,3,2]
         * Output: 4
         * Explanation: All possible pairings (ignoring the ordering of elements) are:
         * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
         * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
         * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
         * So the maximum possible sum is 4.
         */
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }

        int max = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i+= 2){
            max += nums[i];
        }

        return max;
    }
}
