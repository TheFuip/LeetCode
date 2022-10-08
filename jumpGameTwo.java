/**
 * jumpGameTwo
 */
public class jumpGameTwo {

    public static void main(String[] args) {
        /*
         * You are given a 0-indexed array of integers nums of length n. You are
         * initially positioned at nums[0].
         * 
         * Each element nums[i] represents the maximum length of a forward jump from
         * index i. In other words, if you are at nums[i], you can jump to any nums[i +
         * j] where:
         * 
         * 0 <= j <= nums[i] and
         * i + j < n
         * Return the minimum number of jumps to reach nums[n - 1]. The test cases are
         * generated such that you can reach nums[n - 1].
         */

         int[] nums = {1,2,3};

         System.out.println(jump(nums));
    }

    public static int jump(int[] nums){
        if(nums.length == 1){
            return 0;
        }

        int count = 0;
        int min = 0;
        int max = 0;

        //we start at the beggining of the loop and end at the second last index, since the minimum aside from 0 can be 1
        for(int i = 0; i < nums.length - 1; i++){
            //if the current index + nums[i] is greater than the max set max to i + nums[i]
            if(i + nums[i] > max){
                max = i + nums[i];
            }
            //if i equals count add 1 to minimum, and set count to max
            if(i == count){
                min++;
                count = max;
            }
        }

        return min;
    }
}