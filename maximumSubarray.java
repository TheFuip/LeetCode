import java.util.*;
public class maximumSubarray {
    public static void main(String[] args) {
        /*
         * Given an integerm find the contingous subarray  (containing at least one number) which has the largest sum and return it's sum
         * EX: -2,1,-3,4,-1,2,1,-5,4 -> returns 6, since [4,-1,2,1] has the largest sum of 6
         * divide and conquer
         * retrictions 10^5 aka = 1000
         */
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    //dynamic programming solution
    public static int maxSubArray(int[]nums){
        //if there is only 1 value, than the maximum number can be the value of the one element
        if(nums.length == 1){
            return nums[0];
        }

        int[] tempNums = new int[nums.length];
        tempNums[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++){
            tempNums[i] = Math.max(tempNums[i - 1] + nums[i], nums[i]);

            if(tempNums[i] > max){
                max = tempNums[i];
            }
        }

        return max;
    }
}
/*
    O(N)^2 approach
    int size = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i<size; i++){
            sum = 0;
            for(int j = i; j<size; j++){
                sum+=nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
 * Time limit exceeded :(
 */