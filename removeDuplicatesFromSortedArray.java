import java.util.*;

import javax.print.attribute.IntegerSyntax;

public class removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        /*
         * Given an integer array nums sorted in non-decreasing order,
         * remove the duplicates in-place such that each unique element appears only
         * once.
         * The relative order of the elements should be kept the same.
         * non-descending order: 1 2 2 3 3 4 5 6 6 -> 1 2 3 4 5 6
         */
        int[] nums = { 4,4,4,5,6,7,8};
        //nums = removeDuplicates(nums);

        System.out.println(removeDuplicates(nums));

    }

    /*
     * Hint: use a list -> list.toArray()...? ^\/(. .)\/^
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }

}

/*
 * 
 *      works if you want to return an int array without any duplicates
        List<Integer> list = new ArrayList<>();

        //for each integer value within nums array...
        for(Integer n : nums){
            //if the list currently does not contain the current value of n, add it to the list. (This helps filter out the number of duplicates)
            if(!list.contains(n)){
                list.add(n);
            }
        }

        //reset the initial size of the array to the size of the unique numbers within the array
        nums = new int[list.size()];

        //while 'i' is less than the size of the list, set each index of nums to the current iteration within the list
        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }

        return nums;

        x

        works if you want to return an int value (not array) without any duplicates
           //convert to int from string
        String rD = "";
        
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            if(!set.contains(n)){
                set.add(n);
                rD += n + "";
            }else{
                rD += "";
            }
        }

        return Integer.parseInt(rD);

        x
        actual working code... my code the wording on this problem is awful
            int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1])
            nums[i++] = n;
    return i;
 */
