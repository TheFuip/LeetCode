import java.util.Arrays;

public class largestPerimeterTriangle {
    public static void main(String[] args) {
        /*
         * Given an integer array nums, return the largest perimeter of a triangle with
         * a non-zero area, formed from three of these lengths. If it is impossible to
         * form any triangle of a non-zero area, return 0.
         */
        int[] nums = { 3, 2, 3, 4 };
        System.out.println(largestPerimeter(nums));
    }

    /*
     * remember to calculate the perimeter of a triangle, it is A < b < c the necessary and sufficent conditions for these
     * lengths to form a triangle of non-zero area is a + b > c
     */
    public static int largestPerimeter(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        
        //since the array is sorted from least to greatest, start the array at the greatest amount

        for(int i = nums.length - 3; i > -1; i--){
            //here we will check if (a + b) > c -> if it is that means we have met the requirements to calculate the perimeter of a triangle, so return nums[i] + nums[i + 1] + nums[i + 2]
            if(nums[i] + nums[i + 1] > nums[i + 2]){
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        //if the loop ends, it means not a valid triangle so return 0
        return 0;
    }
}
