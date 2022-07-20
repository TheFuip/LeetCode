import java.util.Arrays;

public class findDuplicateNumber {
    public static void main(String[] args) {
        /*
         * Given an array of integers containing n + 1 integers where each integer is in the range [1, n] inclusive.
         * There is only one repeated number in nums. Return this repeated number.
         * You must solve the problem without modifying the array nums and only use constant extra space.
         */

         int[] nums = {1,3,2,4,4};

         System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums){

        //sort the array from least to greatest
        Arrays.sort(nums);

        //from here we can determind that if the next value in the array is equal with the last one it must be the duplicate
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }

        return -1;
    }
}
