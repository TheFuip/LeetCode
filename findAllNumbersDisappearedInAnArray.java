import java.util.*;

public class findAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        /*
         * Given an array nums of n integers where nums[i] is in the range [1, n],
         * return an array of all the integers in the range [1, n] that do not appear in
         * nums.
         */
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 }; // -> [1,2,2,3,3,4,7,8]

        System.out.println(findDisappearedNumbers(nums));
    }

    /*
     * The program is pretty simple instead of checing for specific values inside of the array we will just check if the set contains the i'th + 1 value of the current iteration
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        //populate hashset with array values
        for(int n : nums){
            set.add(n);
        }

        //start from the beggining and check if the set already contains the (i + 1)'th value
        //for example [1,3] -> [2] ->  because there is a length of 2 it checks if the set contains the first value (0 + 1) = 1 (which it does), followed by (1 + 1) = 2 (it doesnt so add this value to the list)
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(i + 1)){
                res.add(i + 1);
            }
        }

        return res;
    }
}
