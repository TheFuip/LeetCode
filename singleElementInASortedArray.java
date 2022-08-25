/**
 * singleElementInASortedArray
 */
public class singleElementInASortedArray {

    public static void main(String[] args) {
        /*
         * You are given a sorted array consisting only of integers where every element appears exactly twice,
         * except for one element which appears exactly once.
         * Return the single element that appears only once.
         * Your solution must run O(log n) time and O(1) space.
         */
        int[] nums = {1,1,3};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums){
        //if there is only 1 element in the array, this can only be the non duplicate element
        if(nums.length == 1){
            return nums[0];
        }

        int start = 0;
        int next = start + 1;
        int end = nums.length - 1;

        while(next < end){
            if(nums[start] != nums[next]){
                return nums[start];
            }

            if(nums[start] == nums[next]){
                start+=2;
                next = start + 1;
            }
        }

        return nums[nums.length - 1];
    }
}

/*
 * optimal binary search solution
 * 
 *      int start = 0, end = nums.length - 1;

        while (start < end) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1]) end = mid;

            // We found a pair. The single element must be on the right.
            // Example: |1 1 3 3 5 6 6|
            //               ^ ^
            // Next:     1 1 3 3|5 6 6|
            else start = mid + 2;
        }

        // 'start' should always be at the beginning of a pair.
        // When 'start > end', start must be the single element.
        return nums[start];

        //other acceptable solution :: slower runtime tho
        if(nums.length == 1){
            return nums[0];
        }
        
        for(int i = 0; i < nums.length - 1; i+=2){
            if(nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
 */