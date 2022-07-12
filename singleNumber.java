import java.util.*;

public class singleNumber {
    public static void main(String[] args) {
        /*
         * Given a non empty array of integers, every element appears twice
         * except for one. Find the single one.
         * 
         */
        int[] nums = {3,1,1,2,2};
        System.out.println(single(nums));
    }

    //xor solution
    public static int single(int[] nums){
        int ans = 0;

        for(int n : nums){
            ans^=n;
            System.out.print(ans + ", ");
        }

        return ans;
    }
}
/*
working solution 1
 *   Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1){
                return nums[i];
            }
        }

        return -1;
 */