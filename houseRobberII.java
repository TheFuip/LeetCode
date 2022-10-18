public class houseRobberII {
    public static void main(String[] args) {
        /*
         * You are a professional robber planning to rob houses along a street. Each
         * house has a certain amount of money stashed. All houses at this place are
         * arranged in a circle. That means the first house is the neighbor of the last
         * one. Meanwhile, adjacent houses have a security system connected, and it will
         * automatically contact the police if two adjacent houses were broken into on
         * the same night.
         * 
         * Given an integer array nums representing the amount of money of each house,
         * return the maximum amount of money you can rob tonight without alerting the
         * police.
         */
        int[] nums = { 1, 2, 3};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        

        int odd = dp(nums, 1, nums.length - 1);
        int even = dp(nums, 0, nums.length - 2);

        return Math.max(odd, even);
    }

    private static int dp(int[] nums, int start, int end) {
        //this array will keep track of the moneys collected from da house, at the end we will return the final array aka money[end] which will contain the total robbable amount
        //since this array contains the sums of nums[1] + ... + nums[n], etc.
        int[] money = new int[nums.length];

        //since we can either start at house 1 or 2 (0, 1 if you calculate by using array indices...) money[start] will be equivalent to nums[start]
        money[start] = nums[start];

        //since we start i, an additional + 2 indices from start we need to determine the value of start + 1, otherwise this value will be read as 0, and may effect results
        //to do this we take money[start + 1] and fill the value with the maximum sum at nums[start + 1] or nums[start] basically which is greater nums[1] or nums[0] -> this wll be the base logic of the program
        money[start + 1] = Math.max(nums[start + 1], nums[start]);

        for(int i = start + 2; i <= end; i++){
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }

        //money[end] aka the final index will contain the total robbable amount
        return money[end];
    }
}
