import java.util.Arrays;

public class firstMissingPositive {
    public static void main(String[] args) {
        /*
         * Given an unsorted array, return the smallest missing positive integer.
         * Using an algorithm that runs in O(n) and uses constant extra space.
         * 
         * Example: [1,2,0] = 3 -> since 3 would be the next positive number
         * 
         * Example: [3,4,-1,1] = 2 since 2 would be the next positive number
         * 
         * Example [7,8,9,11,12] = 1 -> 1 would be the SMALLEST MISSING POSITIVE integer
         * 
         * [16,-10,14,13,8,0,13,-1,-9,6,0,-6,15,13,6,18,-2,2,7]
         */
        int[] nums = {0,0,3}; // [2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648] -> 4 | sorted = -2147483648,-1,0,1,2,3,2147483645,2147483646,2147483647

        System.out.println(firstMissingPos(nums));
    }

    /**
     * @param nums
     * @return
     */
    public static int firstMissingPos(int[] nums) {
        // base case: if the array only has 1 val and if that value is either greater or
        // less than 1 just return 1
        if (nums.length < 2 && nums[0] > 1 || nums.length < 2 && nums[0] < 1) {
            return 1;
        }
        // second base case if the answer is exactly one just return the length of nums
        // + 1
        if (nums.length < 2 && nums[0] == 1) {
            return nums.length + 1;
        }

        // first sort the array from least to greatest
        Arrays.sort(nums);

        // after sorting we can check if the first value in the array (i.e, the lowest
        // value) does not contain a 1 and is greater than 0, we know this is the smallest missing positive
        // integer

        if (nums[0] > 0 && nums[0] - 1 > 0) {
            return 1;
       }

        // this will be used to discover any discrepancies pertaining to the size
        int temp = nums[0];

        //will be used to keep track if the number 1 appears in the array at all if its value is false we can just return 1 since we know the value count not be found in the for loop the missing positive number is 1
        boolean contains1 = temp == 1;

        for (int i = 1; i < nums.length; i++) {
            //if the val 1 appears while cycling through nums array set boolean val to true indicating 1 is present
            if(nums[i] == 1){
                contains1 = true;
            }

            //if temp has reached a value greater than 0 and the array has yet to see the integer 1 (indicating contains1 is false) return 1, as the array is missing 1 ergo, this is the smallest missing positive number
            if(temp > 0 && contains1 == false){
                return 1;
            }

            //if temp is greater than 0 and nums[i] is greater than 0 and nums[i] - temp is greater than 1 -> return temp + 1 indicating the missing value
            if (temp > 0 && nums[i] > 0 && nums[i] - temp > 1) {
                return temp + 1;
            }

            //update temp to nums[i] each iteration
            temp = nums[i];
        }

        //if contains1 is false after cycling that means the array does not contain the value 1, therefore we know 1 is the smallest missing positive so return it
        if(contains1 == false){
            return 1;
        }

        //return 1 if the last value in the nums array is less than or equal to 0; otherwise add + 1 to the last value of the nums array
        return nums[nums.length - 1] <= 0 ? 1 : nums[nums.length - 1] + 1;
    }
}
/*
 * // base case: if the array only has 1 val and if that value is either greater or
        // less than 1 just return 1
        if (nums.length < 2 && nums[0] > 1 || nums.length < 2 && nums[0] < 1) {
            return 1;
        }
        // second base case if the answer is exactly one just return the length of nums
        // + 1
        if (nums.length < 2 && nums[0] == 1) {
            return nums.length + 1;
        }

        // first sort the array from least to greatest
        Arrays.sort(nums);

        // after sorting we can check if the first value in the array (i.e, the lowest
        // value) does not contain a 1 and is greater than 0, we know this is the smallest missing positive
        // integer

        if (nums[0] > 0 && nums[0] - 1 > 0) {
            return 1;
       }

        // this will be used to discover any discrepancies pertaining to the size
        int temp = nums[0];

        //will be used to keep track if the number 1 appears in the array at all if its value is false we can just return 1 since we know the value count not be found in the for loop the missing positive number is 1
        boolean contains1 = temp == 1;

        for (int i = 1; i < nums.length; i++) {
            //if the val 1 appears while cycling through nums array set boolean val to true indicating 1 is present
            if(nums[i] == 1){
                contains1 = true;
            }

            //if temp has reached a value greater than 0 and the array has yet to see the integer 1 (indicating contains1 is false) return 1, as the array is missing 1 ergo, this is the smallest missing positive number
            if(temp > 0 && contains1 == false){
                return 1;
            }

            //if temp is less than 0 and nums[i] is greater than 0 and temp + nums[i] > 0 return 1
            //
            if (temp < 0 && nums[i] > 0 && temp + nums[i] > 0) {
                return 1;
            } else if (temp > 0 && nums[i] > 0 && nums[i] - temp > 1) {
                return temp + 1;
            }
            temp = nums[i];
        }

        if(contains1 == false){
            return 1;
        }

        return nums[nums.length - 1] <= 0 ? 1 : nums[nums.length - 1] + 1;
 */