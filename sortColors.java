import java.util.*;
public class sortColors {
    public static void main(String[] args) {
        /*
         * Given an array nums with n objects colored red, white, or blue, sort them
         * in-place so that objects of the same color are adjacent, with the colors in
         * the order red, white, and blue.
         * 
         * We will use the integers 0, 1, and 2 to represent the color red, white, and
         * blue, respectively.
         * 
         * You must solve this problem without using the library's sort function.
         * 
         * Input: nums = [2,0,2,1,1,0]
         * Output: [0,0,1,1,2,2]
         */
        int[] nums = {2,0,1};
        sortedColors(nums);
    }
    public static void sortedColors(int[] nums){
        
        int start = 0;
        int end = nums.length - 1;
        int i = 0;

        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, start++, i++);
            } else if (nums[i] == 2) {
                swap(nums, end--, i);
            }else{
                i++;
            }
        }

        for(int n : nums){
            System.out.print(n + ", ");
        }
    }

    private static void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
