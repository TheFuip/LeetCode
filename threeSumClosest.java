import java.util.Arrays;

public class threeSumClosest {
    public static void main(String[] args) {
        /*
         * Given an integer array nums of length n and an integer target, find three
         * integers in nums such that the sum is closest to target.
         * 
         * Return the sum of the three integers.
         * 
         * You may assume that each input would have exactly one solution.
         */
        int[] nums = {-1,2,1,-4};
        System.out.println(solution(nums, 1));
    } 
    public static int solution(int[] nums, int target){
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            //from here we will employ binary search mechanism
            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                int temp = nums[i] + nums[start] + nums[end];

                if(Math.abs(target - temp) < min){
                    res = temp;
                    min = Math.abs(target - temp);
                }

                //if the array include the target we immediately know no other value will be closer so return this value
                if(temp == target){
                    return target;
                }

                if(temp < target){
                    start++;
                }else{
                    end--;
                }
            }
        }

        return res;
    }
}
