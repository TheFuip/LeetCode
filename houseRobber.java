/**
 * houseRobber
 */
import java.util.*;

public class houseRobber {

    /*
     * You are a professional robber planning to rob houses along a street. Each
     * house has a certain amount of money stashed, the only constraint stopping you
     * from robbing each of them is that adjacent houses have security systems
     * connected and it will automatically contact the police if two adjacent houses
     * were broken into on the same night.
     * 
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the
     * police.
     */
    public static void main(String[] args) {
        int[] nums = {2,4,0,0,0,1,9,0,11};
        
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        //base case if there is only 1 value inside of nums
        if(nums.length < 2){
            return nums[nums.length - 1];
        }

        //another easy case: just return the max if there are 2 elements inside of nums
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //where dp stands for dynamic programming set new array proportionate to the length of nums
        int[] dp = new int[nums.length];

        //the first index will just contain the value inside of nums[0]
        dp[0] = nums[0];
        
        //dp[1] will contain the max of nums[0] and nums[1]
        dp[1] = Math.max(nums[0], nums[1]);

        //set the loop to start at 2, as the first 2 values are taken care of
        for(int i = 2; i < dp.length; i++){
            //here the current nth iteration of dp will be set to the max value of nums plus the previous 2 elements of dp. in this case -2 elements back and -1 element back
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        //with this logic the last element inside of dp will always be the largest
        return dp[dp.length - 1];
    }
}

/*
 * for(int i = 0; i < temp.length; i++){
            System.out.println("i = "+i + " : " + temp[i]);
        }
 */