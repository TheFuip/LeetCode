import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class removeElement {
    public static void main(String[] args) {
        /*
         * Given an integer array nums and an integer val, remove all occurences of val
         * in nums in-place.
         * The relative order of the elements may be changed.
         * DO not allocate space for another array. You must do this by modifying the
         * input array in-place with O(1) extra memory.
         * 
         * EX: nums = [3,2,2,3] | val = 3 -> should return 2, since after removing how
         * many times the val (3) appears the array is left with 2 elements ([2,2])
         * EX: nums = [0,1,2,2,3,0,4,2] | val = 2 -> should return 5 since after
         * removing how many times val(2) appears in the array; it is left with 5
         * remaining elements ([0,1,4,0,3])
         */
        int[] nums = { 3, 2, 2, 3 };
        System.out.println(solution(nums, 3));
    }

    public static int solution(int[] nums, int val) {
        int count = 0;

        //check if the current iteration of nums[i] is not equal to the value if it is set nums[count] (initially starts off at 0) to the value of nums[i] and increment count
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }
}
/*
 * solution to remove elements that contain val without the need of a new array
 *  public static int[] solution(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : nums) {
            if (n != val) {
                list.add(n);
            }
        }

        nums = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }

        return nums;
    }
 */