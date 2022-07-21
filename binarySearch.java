public class binarySearch {
    public static void main(String[] args) {
        /*
         * Given an array of integers which is sorted in ascending order, and an integer
         * target.
         * Write a function to search target in nums. if target exists return it's
         * index,
         * otherwise return -1;
         */
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        //divide and conquer solution
        while(start <= end){
            //init middle, which is the middle of the array
            int middle = start + (end - start) / 2;

            //check if the middle element contains the target value
            if(nums[middle] == target){
                return middle;
            }

            //check if the target is greater than the middle, if it is we know to only focus on ascending values (values strictly higher than the middle)
            if(target > nums[middle]){
                start = middle + 1;
            }
            //otherwise we know nums[middle] is too high, so the target must be lower. In this case we can only focus on values descending from the middle (values strictly lower than the middle)
            else{
                end = middle - 1;
            }
        }
        
        //if the value is not foundin binary search just return 1;
        return -1;
    }
}
/*
 * Recursive implementation:
 * 
 *  int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
  
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
  
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
  
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
  
        // We reach here when element is not present
        // in array
        return -1;
    }

     int pivot, left = 0, right = nums.length - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) return pivot;
      if (target < nums[pivot]) right = pivot - 1;
      else left = pivot + 1;
    }
    return -1;
 */