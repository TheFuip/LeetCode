import java.util.Arrays;

public class kthLargestElementInAnArray {
    public static void main(String[] args) {
        /*
         * Given an integer array nums and an integer k, return the kth largest element
         * in the array.
         * 
         * Note that it is the kth largest element in the sorted order, not the kth
         * distinct element.
         * 
         * You must solve it in O(n) time complexity.
         */
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[]nums, int k){
        /*
         * Quick selection ::
         * first sort the array and then just return nums[nums.length - k]
         * k will always be 1 or more and never anything higher than the array length
         * if k is 1 that means the first highest element, since the array is sorted return nums[nums.length - k]
         * the same applies if it asks for the second, third, fourth highest, etc...
         */
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
