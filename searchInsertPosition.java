import java.util.*;

public class searchInsertPosition {
    public static void main(String[] args) {
        /*
         * Given a sorted array of distinct integers and a target value, return the index if the target is found.
         * If not, return the index where it would be if it were inserted in order.
         */
        int[] nums = {9,11,13,16,18};

        System.out.println(searchInsert(nums, 23));
    }

    //1ms solution
    public static int searchInsert(int[]nums, int target){
        //have a variable to hold the current num indice value
        int indexPOS = 0;

        for(int i = 0; i < nums.length; i++){
            //if the current iteration of nums is equal to the target return the current index 'i'
            if(nums[i] == target){
                return i;
            }else if(nums[i] < target){
                //if the current index val of nums is less than the target increment the indexPOS value, in order to keep up with the indice value from where target would intiialy be placed if the target is not found in the nums array
                indexPOS++;
            }
        }

        return indexPOS;
    }
}
/*
    ALT solution w/ hashmap the first one is slightly better tho hashmap has 4ms
        Map<Integer, Integer> map = new HashMap<>();
        int indexPOS = 0;

        for(int i = 0; i < nums.length; i++){
           if(map.containsKey(target)){
                return map.get(target);
           }else if(nums[i] < target){
                indexPOS++;
           }

           map.put(nums[i], i);
        }

        return indexPOS;
 */