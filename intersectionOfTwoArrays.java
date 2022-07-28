import java.util.*;

public class intersectionOfTwoArrays {
    public static void main(String[] args) {
        /*
         * Given two integer arrays, return an array of their intersection. Each element in the result must be unique
         * and you may return the result in any order.
         * 
         * EX: nums1 [1,2,3] | nums2 [2,3,4] - > [2,3] since 2, and 3 appear in both arrays
         */
        int[] nums1 = {4,9,5};
        int[] nums2 = {7};

        for(int n : intersection(nums1, nums2)){
            System.out.print(n + ", ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2){
        //base case: used to buy up some speed in terms of time complexity
        if(nums1.length < 2 && nums2.length < 2 && nums1[0] != nums2[0]){
            return new int[]{};
        }

        /*
         * 2 pointer approach with 2 hashsets
         */

        HashSet<Integer> set1 = new HashSet<>();

        //hashset1 will add all values into num1
        for(int n: nums1){
            set1.add(n);
        }

        HashSet<Integer> set2 = new HashSet<>();

        //hashset2 will monitor if the current iteration of n inside of nums2 appears in nums1 if it does add that value to set2
        for(int n : nums2){
            if(set1.contains(n)){
                set2.add(n);
            }
        }

        //create new int[] called ans -> and import the data from set2 into that
        int[] ans = set2.stream().mapToInt(i -> i).toArray();
        
        return ans;

    }
}

/*
 * Binary Search Option::
 * 
 *     public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
 */