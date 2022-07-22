import java.util.ArrayList;
import java.util.Arrays;

public class missingNumber {
    public static void main(String[] args) {
        /*
         * Given an array containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
         * EX: [3,0,1] -> 2, there are 3 numbers but 2 is the missing number from the range
         * EX: [0,1] -> 2
         * ex: [9,6,4,2,3,5,7,0,1] -> 8
         * 
         * check for [2,0]
         */
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(solution(nums));
    }

    //O(n) linear runtime
    public static int solution(int[] nums){
        //populate the list with all values of nums
        ArrayList<Integer> list = new ArrayList<>();

        //first sort the arrays this will be easy for us to determine whether the number is missing 
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            //add each element to the list
            list.add(nums[i]);

            //if the list does not contain i, we know the value of i is the missing number
            if(!list.contains(i)){
                return i;
            }
        }

        //otherwise just return the length
        return nums.length;
    }
}
/*
 *  int sum = 0;
        for(int num: nums){
            sum += sum;
        }
    
    return ( (nums.length * (nums.length + 1) ) - 2 * sum ) / 2;
 */