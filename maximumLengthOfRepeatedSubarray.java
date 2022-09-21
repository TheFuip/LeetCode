import java.util.*;

public class maximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        /*
         * Given two integer arrays nums1 and nums2, return the maximum length of a
         * subarray that appears in both arrays.
         */
        int[] nums1 = { 1, 2, 3, 2, 1 };
        int[] nums2 = { 3, 2, 1, 1, 4, 7 }; // 3 [1,2,3]
        System.out.println(findLength(nums1, nums2));
    }

    /*
     * Since a common subarray of A and B must start at some A[i] and B[j], let
     * dp[i][j] be the longest common prefix of A[i:] and B[j:]. Whenever A[i] ==
     * B[j], we know dp[i][j] = dp[i+1][j+1] + 1. Also, the answer is max(dp[i][j])
     * over all i, j.
     * 
     * We can perform bottom-up dynamic programming to find the answer based on this
     * recurrence. Our loop invariant is that the answer is already calculated
     * correctly and stored in dp for any larger i, j.
     */

    public static int findLength(int[] nums1, int[] nums2) {
        // dynamic programming
        int max = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = nums1.length - 1; i > -1; i--) {
            for (int j = nums2.length - 1; j > -1; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
