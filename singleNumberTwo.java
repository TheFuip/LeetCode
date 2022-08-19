import java.util.Arrays;

public class singleNumberTwo {
    public static void main(String[] args) {
        /*
         * Given an integer array nums where every element appears three times except
         * for one, which appears exactly once. Find the single element and return it.
         * 
         * You must implement a solution with a linear runtime complexity and use only
         * constant extra space.
         */
        int[] nums = {1,3,5,8,8,9,5,3,1,1,3,5,8};
        System.out.println(singleNumber(nums));
    }   
    //2-pointer approach
    public static int singleNumber(int[]nums){
        //if there is only 1 element in the array just return the first element, as it is the only single number
        if(nums.length == 1){
            return nums[0];
        }

        //sort the array, to make this algorithm easier
        Arrays.sort(nums);
        
        //here we will have single, set to the first element inside of nums array
        int single = nums[0];
        int count = 0; //since a duplicate number will appear exactly 3 times, this variable will keep trck of it
        
        for(int i = 0; i < nums.length; i++){
            //check if the value of count is 3, if it is that indicates that the current iteration of single is a duplicate, so we should set duplicate to the next value
            if(count == 3){
                single = nums[i];
                count = 0; //also reset count back to 0 to check if the next value contains 3 appearances
            }

            //everytime nums[i] is equal to single value increment count as this is a duplicate
            if(nums[i] == single){
                count++;
            }
        }

        return single;
    }
}
