import java.util.Arrays;
import java.util.HashMap;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        /*
         * Given an integer array, return the length of the longest strictly increasing
         * subsequence.
         * 
         * A subsequence is a sequence that can be derived from an array by deleting
         * some or no elements without changing the order of the remaining
         * elements. For example, [3,6,2,7] is a subsequence of the array
         * [0,3,1,6,2,2,7].
         * 
         * EX: [10,9,2,5,3,7,101,18] = 4 -> The longest increasing substirng is
         * [2,3,7,101]
         * 
         * ex: [7,7,7] = 1
         * 
         * ex: [0,1,0,3,2,3] = 4
         */
        int[] nums = {0,1,0,3,2,3};
        //System.out.println(helperLIS(nums, 2));
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        //n will be set to the length of nums array
        int n = nums.length;

        //create a blank array with a length of how many indexes are contained in nums initialized with all 0
        int[] dp = new int[n];

        //fill the Array dp all with 1's
        Arrays.fill(dp, 1);

        //max will be used esentially as the count for how many numbers fit in a subsequence. By default this value is set to 1, as there will never be a return value less than 1
        int max = 1;

        //time complexity is O (log)^2 since we are iterating over 2 loops, i is set to the second index value of nums
        for(int i=1; i < n; i++){
            //set j to 0 the first index value of nums
            for(int j=0; j <= i-1; j++){
                //if nums[i] is greater than nums[j] set dp[i] to the max value of dp[i] initially vs dp[j] + 1
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            //captures the largest LIS value
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int helperLIS(int[] nums, int n) {
        if(n == nums.length - 1){
            return 1;
        }

        int temp = nums[n];
        int count = -1;
        for(int i = n + 1; i < nums.length; i++){
            System.out.println("temp = " + temp + " : nums[n] = " + nums[i] + " : count = "+count);
            if(temp < nums[i]){
                count++;
                //temp = nums[i];
            }
        }
        return count;
    }
}

/*
 *  if(n == nums.length - 1){
            return 1;
        }

        int temp = nums[n];
        int count = 0;
        for(int i = n + 1; i < nums.length; i++){
            System.out.println("temp = " + temp + " : nums[n] = " + nums[i] + " : count = "+count);
            if(nums[i] < temp && count > 0){
                temp = nums[n + count];
            }
            
            if(temp < nums[i]){
                count++;
                temp = nums[i];
            }
        }
        return count;
 */