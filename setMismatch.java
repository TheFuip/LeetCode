import java.util.*;
public class setMismatch {
    public static void main(String[] args) {
        /*
         * You have a set of integers s, which originally contains all the numbers from
         * 1 to n. Unfortunately, due to some error, one of the numbers in s got
         * duplicated to another number in the set, which results in repetition of one
         * number and loss of another number.
         * 
         * You are given an integer array nums representing the data status of this set
         * after the error.
         * 
         * Find the number that occurs twice and the number that is missing and return
         * them in the form of an array.
         */
        int[] nums = {1,5,3,2,2,7,6,4,8,9};

        for(int n : findErrorNums(nums)){
            System.out.print(n + ", ");
        }
    }

    public static int[] findErrorNums(int[] nums){
        //first sort the array it will be easier and a little bit quicker to determine duplicate results
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        //duplicate will store the value that appears twice, while missing will store the value missing from the array, by default we set this to 1, since if the array does not contain than this is the missing number
        int duplicate = 0;
        int missing = 1;

        //we will loop through nums populating the map's keys with each array value and the 
        for(int n : nums){
            //if the map already contains the current value in the array, set duplicate to n to reflect this
            if(map.containsKey(n)){
                duplicate = n;
            }
            //populate the map with each value contained in the array and how many instances of those values have appeared.
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //start the loop at 1, we can ignore the first value since by default missing is set to 1
        for(int i = 1; i <= nums.length; i++){
            //if the map does not contain the current value of missing, this means we have discovered the missing value -> return a new array contained with duplicate value and missing value
            if(!map.containsKey(missing)){
                return new int[] {duplicate, missing};
            }

            //otherwise if the conditional statement is not met set missing to the current value of i.
            missing = i;
        }

        return new int[]{duplicate, missing};
    }
}
