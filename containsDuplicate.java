import java.util.HashSet;
import java.util.Set;

/**
 * containsDuplicate
 */
public class containsDuplicate {

    public static void main(String[] args) {
        /*
         * Given an integer array, return true if any value appears at least twice in the array, and return false if every element is distinct
         */
        int[] nums = {1,2,3,2};
        System.out.println(isDuplicate(nums));
    }
    public static boolean isDuplicate(int[]nums){
       Set<Integer> dupe = new HashSet<>();

       for(Integer n : nums){
            if(dupe.contains(n)) return true;
            dupe.add(n);
       }
       return false;

    }
}
/* Solution 1 :: Not accepted because exceeded time limit :(
 *  for(int i = 0; i<nums.length; i++){
            for(int j = i + 1; j<nums.length; j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
 */