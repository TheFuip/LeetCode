import java.util.*;

public class wiggleSort {
    public static void main(String[] args) {
        /*
         * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2]
         * < nums[3]....
         * 
         * You may assume the input array always has a valid answer.
         * 
         * Input: nums = [1,5,1,1,6,4]
         * Output: [1,6,1,5,1,4]
         * Explanation: [1,4,1,5,1,6] is also accepted.
         */
        int[] nums = { 1, 5, 1, 1, 6, 4 }; // 1,1,1,4,5,6
        solution(nums);
    }

    public static void solution(int[] nums) {
        //we will create length containing the index length of the last element inside of nums        
        int length = nums.length - 1;

        //we have to use copyOf instead of using int[] ans = nums, because we want ans to store the unsorted data inside of nums, if we use int[] ans = nums it stores the sorted data...? kinda weird but whatever.. so much for a sequential hierarchal language
        int[] ans = Arrays.copyOf(nums, nums.length);

        //sort the array from ascending order
        Arrays.sort(ans);

        //here we will first fill all even spacs inside of the array with the greater values contained in the array specially where b > a
        for(int i = 1; i < nums.length; i+=2){
            nums[i] = ans[length--];
        }
        //here we fill all odd spaces with lower numbers this is where a < b
        for(int i = 0; i < nums.length; i+=2){
            nums[i] = ans[length--];
        }
        
        // print out array
        for (int n : nums) {
            System.out.print(n + ", ");
        }
    }
}

/*
 * solution 1:
 * 
 * 
        int length = nums.length - 1;
        int[] ans = Arrays.copyOf(nums, nums.length);

        Arrays.sort(ans);

        for(int i = 1; i < nums.length; i+=2){
            nums[i] = ans[length--];
        }
        for(int i = 0; i < nums.length; i+=2){
            nums[i] = ans[length--];
        }
 */