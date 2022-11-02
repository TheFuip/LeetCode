import java.util.*;
import java.util.stream.Collectors;

public class findKClosestElements {
    public static void main(String[] args) {
        /*
         * Given a sorted integer array arr, two integers k and x, return the k closest
         * integers to x in the array. The result should also be sorted in ascending
         * order.
         * 
         * An integer a is closer to x than an integer b if:
         * 
         * |a - x| < |b - x|, or
         * |a - x| == |b - x| and a < b
         */
        int[] nums = { 1, 2, 3, 4, 5, 6 };

        System.out.println(findClosestElements(nums, 4, 3));
    }

    // binary search
    // time complexity = O(log(n - k) + k)
    public static List<Integer> findClosestElements(int[] nums, int k, int x) {
        int start = 0;
        int end = nums.length - k;

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (x - nums[middle] > nums[middle + k] - x) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return Arrays.stream(nums, start, start + k).boxed().collect(Collectors.toList());
    }
}

/*
 * Explanation
 * Assume we are taking A[i] ~ A[i + k -1].
 * We can binary research i
 * We compare the distance between x - A[mid] and A[mid + k] - x
 * 
 * @vincent_gui listed the following cases:
 * Assume A[mid] ~ A[mid + k] is sliding window
 * 
 * case 1: x - A[mid] < A[mid + k] - x, need to move window go left
 * -------x----A[mid]-----------------A[mid + k]----------
 * 
 * case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
 * -------A[mid]----x-----------------A[mid + k]----------
 * 
 * case 3: x - A[mid] > A[mid + k] - x, need to move window go right
 * -------A[mid]------------------x---A[mid + k]----------
 * 
 * case 4: x - A[mid] > A[mid + k] - x, need to move window go right
 * -------A[mid]---------------------A[mid + k]----x------
 * 
 * If x - A[mid] > A[mid + k] - x,
 * it means A[mid + 1] ~ A[mid + k] is better than A[mid] ~ A[mid + k - 1],
 * and we have mid smaller than the right i.
 * So assign left = mid + 1.
 * 
 * Important
 * Note that, you SHOULD NOT compare the absolute value of abs(x - A[mid]) and
 * abs(A[mid + k] - x).
 * It fails at cases like A = [1,1,2,2,2,2,2,3,3], x = 3, k = 3
 * 
 * The problem is interesting and good.
 * Unfortunately the test cases is terrible.
 * The worst part of Leetcode test cases is that,
 * you submit a wrong solution but get accepted.
 * 
 * You didn't read my post and up-vote carefully,
 * then you miss this key point.
 * 
 * 
 * Complexity
 * Time O(log(N - K)) to binary research and find result
 * Space O(K) to create the returned list.
 * 
 * 
 */