/**
 * searchInRotatedSortedArray
 */
import java.util.*;
public class searchInRotatedSortedArray {

    public static void main(String[] args) {
        /*
         * There is an integer array nums sorted in  non-decreasing order (not necessarily with distinct values).
         * Before being passed to your function, nums is rotated at an unknown pivot index k -> (0 <= k < nums.length)
         * such that the resulting array is [nums[k], nums[k+1]], ... nums[n - 1], nums[0], nums[1] ... ,nums[k - 1] (0-indexed.)
         * For example [0,1,2,3,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
         * 
         * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
         * 
         * You must decrease the overall operations steps as much as possible.
         */
        int[] nums = {2,2,2,3,2,2,2};
        
        System.out.println(search(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }
            // which array does pivot belong to.
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            // which array does target belong to.
            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotArray) {
                    start = mid + 1; // pivot in the first, target in the second
                } else {
                    end = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    private static boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    private static boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}