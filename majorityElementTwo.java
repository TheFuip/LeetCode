import java.util.*;
public class majorityElementTwo {
    public static void main(String[] args) {
        /*
         * Given an integer array of size n, find all the elements that appear more than
         * n/3 times.
         */
        int[] nums = {3,2,2,2,3};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[]nums){
        ArrayList<Integer> list = new ArrayList<>();
        
        //if there is only 1 element in the array, add it to the list and return it
        if(nums.length == 1){
            list.add(nums[nums.length - 1]);
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        map.forEach((k, v) ->{
            if(v > nums.length / 3){
                list.add(k);
            }
        } );

        return list;
    }
}
