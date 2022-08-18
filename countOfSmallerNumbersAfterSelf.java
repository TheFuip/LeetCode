import java.util.*;
import java.util.stream.*;

public class countOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        /*
         * Given an integer array nums, return an integer array where counts[i] is the
         * number of smaller elements
         * to the right of nums[i]
         */
        int[] nums = { 26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41 };

        System.out.println(countSmaller(nums));
    }

    // binary search
    public static List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        //create new array proportionate to the size of nums array, which will hold the count for every individual index
        Integer[] ans = new Integer[nums.length];

        //loop starting from the back of the array until the beginning.
        //index will hold the number of indexes to the right that are smaller
        //finally we will add that value and the current value of nums to the list
        for(int i = nums.length - 1; i > -1; i--){
            int index = countSmallerHelper(list, nums[i]);
            ans[i] = index;
            list.add(index, nums[i]);
        }

        return Arrays.asList(ans);
    }

    public static int countSmallerHelper(ArrayList<Integer> list, int index){
        //first check if the list size is 0, just return 0 as there are no additional values smaller
        if(list.size() == 0){
            return 0;
        }
        
        //binary search ->
        int start = 0;
        int end = list.size() - 1;

        //check if the last value of the list is less than the current index(nums[i] passed in)
        //if it is return end + 1
        if(list.get(end) < index){
            return  end + 1;
        }
        
        //if the list index of start is greater or equal to index(nums[i] passed in) return 0
        if(list.get(start) >= index){
            return 0;
        }

        while(start + 1 < end){
            //create a midpoint which is start + (end - start) / 2 i.e, the middle part of both start and end...
            int mid = start + (end - start) / 2;

            //if list(mid) is less than index set start to mid + 1, as start can move up since the value is to small
            if(list.get(mid) < index){
                start = mid + 1;
            }else{
                end = mid; //otherwise set the end to the middle value
            }
        }

        //if the list(start) is greater or equal to the target (current value of nums[i] return start)
        if(list.get(start) >= index){
            return start;
        }

        //otherwise just return end
        return end;
    }
}



/*
 * o(n) ^ 2 time complexity is too slow
 * 
 *  ArrayList<Integer> list = new ArrayList<>();

        // if the array has a length of just 1 return the list with just a 0 added to it
        if (nums.length == 1) {
            list.add(0);
            return list;
        }

        //o(N)^2 time complexity
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    count++;
                }
            }
            list.add(count);
        }

        return list;
 */