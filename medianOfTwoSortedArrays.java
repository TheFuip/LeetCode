import java.util.*;

public class medianOfTwoSortedArrays {
    public static void main(String[] args) {
        /*
         * Given 2 sorted arrays nums1, and nums2 of size m and n.
         * Return the media of 2 sorted arrays.
         * Ex: nums1[1,3,6]; nums2[2,8,12] | merged[1,2,3,6,8,12] | the median is the
         * average of the 2 middle elemented at index 2 and 3 since the length is 6
         * (3) + (6) = 9 -> 9/2 = 4.5 | return 4.5
         * 
         */

        int[] nums1 = { 11};
        int[] nums2 = { 14};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // base case if nums1 and nums2 only contains 1 element each
        if (nums1.length == 1 && nums2.length == 1) {
            return (double) (nums1[nums1.length - 1] + nums2[nums2.length - 1]) / (nums1.length + nums2.length);
        }

        // we will have an array that contains the values of both nums1 and nums2
        int[] nums3 = new int[nums1.length + nums2.length];

        // copy both arrays value to nums3
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

        // after the nums3 has been populated to include all the arrays of both nums1
        // and nums2 sort nums3
        Arrays.sort(nums3);

        // only if the number is an odd number we can return the middle
        if (nums3.length % 2 == 1) {
            return nums3[(nums3.length - 1) / 2];
        }

        //otherwise nums3 length is even so we must find 2 values to return the center most left and the center most right
        //to do this we take nums3[nums.length / 2] for the right most value, then nums3[(nums3.length - 1) / 2] for the center most left
        //we add those values up and divide by 2 which will give us the median of the even array
        return (double) (nums3[nums3.length / 2] + nums3[(nums3.length - 1) / 2]) / 2;
    }
}
/*
 * binary search approach (maybe a bit more concise with O(log(min(M,N))))
 * 
 *   int N1 = nums1.size();
    int N2 = nums2.size();
    if (N1 < N2) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.
    
    int lo = 0, hi = N2 * 2;
    while (lo <= hi) {
        int mid2 = (lo + hi) / 2;   // Try Cut 2 
        int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly
        
        double L1 = (mid1 == 0) ? INT_MIN : nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
        double L2 = (mid2 == 0) ? INT_MIN : nums2[(mid2-1)/2];
        double R1 = (mid1 == N1 * 2) ? INT_MAX : nums1[(mid1)/2];
        double R2 = (mid2 == N2 * 2) ? INT_MAX : nums2[(mid2)/2];
        
        if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
        else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
        else return (max(L1,L2) + min(R1, R2)) / 2;	// Otherwise, that's the right cut.
    }
    return -1;
 */